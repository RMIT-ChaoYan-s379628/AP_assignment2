package Main;

import java.util.LinkedList;

import Exception.NoAvailableException;
import Exception.NoParentException;
import Exception.NotToBeClassmatesException;
import Exception.NotToBeColleaguesException;
import Exception.NotToBeCoupledException;
import Exception.NotToBeFriendsException;
import Exception.TooYoungException;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description
 */

public class RelationShipManager {

	private static RelationShipManager s_manager = null;
	private LinkedList<RelationShip> m_lstRelations = null;

	private RelationShipManager() {
		m_lstRelations = new LinkedList<>();
	}

	public static RelationShipManager getInstance() {
		if (null == s_manager) {
			s_manager = new RelationShipManager();
		}
		return s_manager;
	}

	public LinkedList<RelationShip> getRelations() {
		return this.m_lstRelations;
	}

	public void addRelationShip(Person first, Person second, String type)
			throws TooYoungException, NotToBeFriendsException, NotToBeCoupledException, NoAvailableException,
			NotToBeColleaguesException, NotToBeClassmatesException, NoParentException {
		if (checkRelationShip(first, second).equals("null")) {
			if (type.equals("friends")) {
				if (first instanceof YoungChild || second instanceof YoungChild) {
					throw new TooYoungException();
				} else if ((first instanceof Adult && second instanceof Child)
						|| (second instanceof Adult && first instanceof Child)) {
					throw new NotToBeFriendsException();
				} else if ((second.getAge() - first.getAge() > 3 || first.getAge() - second.getAge() > 3)
						&& first instanceof Child && second instanceof Child) {
					throw new NotToBeFriendsException();
				} else {
					m_lstRelations.add(new FriendShip(first, second));
				}
			} else if (type.equals("couple")) {
				if (!(first instanceof Adult) || !(second instanceof Adult)) {
					throw new NotToBeCoupledException();
				} else if (isMarried(first) || isMarried(second)) {
					throw new NoAvailableException();
				} else {
					m_lstRelations.add(new CoupleShip(first, second));
				}
			} else if (type.equals("colleague")) {
				if (!(first instanceof Adult) || !(second instanceof Adult)) {
					throw new NotToBeColleaguesException();
				} else {
					m_lstRelations.add(new ColleagueShip(first, second));
				}
			} else if (type.equals("classmate")) {
				if (first instanceof YoungChild || second instanceof YoungChild) {
					throw new NotToBeClassmatesException();
				} else {
					m_lstRelations.add(new ClassmateShip(first, second));
				}
			} else if (type.equals("sibling")) {
				m_lstRelations.add(new SiblingShip(first, second));
			} else if (type.equals("parent")) {
				Person parent = null;
				Person child = null;
				if (first.getAge() < second.getAge()) {
					parent = second;
					child = first;
				} else {
					parent = first;
					child = second;
				}
				if (!isMarried(parent)) {
					throw new NoParentException();
				} else {
					LinkedList<Person> parents = child.getParents();
					if (parents.size() != 0) {
						boolean contain = false;
						for (int i = 0; i < parents.size(); i++) {
							if (parents.get(i).getName().equals(parent.getName())) {
								contain = true;
							}
						}
						if (!contain) {
							if (child.addParent(parent)) {
								m_lstRelations.add(new ParentShip(parent, child));
							}
						}
					} else {
						if (child.addParent(parent)) {
							m_lstRelations.add(new ParentShip(parent, child));
						}
					}
				}
			}
		}
	}

	public String checkRelationShip(Person person1, Person person2) {
		if (null != person1 && null != person2 && person1 != person2) {
			Person firstPerson = null, secondPerson = null;
			for (int nIndex = 0; nIndex < m_lstRelations.size(); nIndex++) {
				firstPerson = m_lstRelations.get(nIndex).getFirstPerson();
				secondPerson = m_lstRelations.get(nIndex).getSecondPerson();
				if ((person1 == firstPerson && person2 == secondPerson)
						|| (person2 == firstPerson && person1 == secondPerson)) {
					if (m_lstRelations.get(nIndex) instanceof ParentShip) {
						return "parent";
					} else if (m_lstRelations.get(nIndex) instanceof ClassmateShip) {
						return "classmate";
					} else if (m_lstRelations.get(nIndex) instanceof ColleagueShip) {
						return "colleague";
					} else if (m_lstRelations.get(nIndex) instanceof CoupleShip) {
						return "couple";
					} else if (m_lstRelations.get(nIndex) instanceof FriendShip) {
						return "friends";
					} else if (m_lstRelations.get(nIndex) instanceof SiblingShip) {
						return "sibling";
					}
				}
			}
		}
		return "null";
	}

	public LinkedList<Person> getChildren(Person person) {
		LinkedList<Person> lstChildren = new LinkedList<Person>();
		if (null != person) {
			RelationShip r = null;
			for (int nIndex = 0; nIndex < m_lstRelations.size(); nIndex++) {
				r = m_lstRelations.get(nIndex);
				if (r instanceof ParentShip && r.getFirstPerson() == person) {
					lstChildren.add(r.getSecondPerson());
				}
			}
		}
		return lstChildren;
	}

	public LinkedList<Person> getParents(Person person) {
		LinkedList<Person> lstParents = new LinkedList<>();
		if (null != person) {
			RelationShip r = null;
			for (int nIndex = 0; nIndex < m_lstRelations.size(); nIndex++) {
				r = m_lstRelations.get(nIndex);
				if (r instanceof ParentShip && r.getSecondPerson() == person) {
					lstParents.add(r.getFirstPerson());
				}
			}
		}
		return lstParents;
	}

	public LinkedList<Person> getSiblings(Person person) {
		LinkedList<Person> lstSiblings = new LinkedList<Person>();
		if (null != person) {
			RelationShip r = null;
			Person sibling = null;
			for (int nIndex = 0; nIndex < m_lstRelations.size(); nIndex++) {
				r = m_lstRelations.get(nIndex);
				if (r instanceof SiblingShip) {
					sibling = r.getAnotherPerson(person);
					lstSiblings.add(sibling);
				}
			}
		}
		return lstSiblings;
	}

	public boolean isMarried(Person person) {
		for (int nIndex = 0; nIndex < m_lstRelations.size(); nIndex++) {
			if (m_lstRelations.get(nIndex) instanceof CoupleShip && m_lstRelations.get(nIndex).hasPerson(person)) {
				return true;
			}
		}
		return false;
	}

	public boolean deletePerson(Person person) {
		if (getChildren(person).size() > 0) {
			return false;
		} else {
			for (int nIndex = 0; nIndex < m_lstRelations.size();) {
				if (m_lstRelations.get(nIndex).hasPerson(person)) {
					m_lstRelations.remove(nIndex);
				} else {
					nIndex++;
				}
			}
			return true;
		}
	}

	public LinkedList<RelationShip> getAllRelatedRelation(Person person) {
		LinkedList<RelationShip> relationships = new LinkedList<>();
		for (int nIndex = 0; nIndex < m_lstRelations.size(); nIndex++) {
			if (m_lstRelations.get(nIndex).hasPerson(person)) {
				relationships.add(m_lstRelations.get(nIndex));
			}
		}
		return relationships;
	}
}
