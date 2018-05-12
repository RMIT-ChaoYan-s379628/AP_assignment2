package Main;
import java.util.ArrayList;

public class RelationShipManager {
	private static RelationShipManager s_manager = null;
	private ArrayList<RelationShip> m_lstRelations = null;

	private RelationShipManager() {
		m_lstRelations = new ArrayList<RelationShip>();
	}

	public static RelationShipManager getInstance() {
		if (null == s_manager)
			s_manager = new RelationShipManager();
		return s_manager;
	}

	public void addRelationShip(RelationShip r) {
		m_lstRelations.add(r);
	}

	public boolean checkRelationShip(Person person1, Person person2) {
		if (null != person1 && null != person2 && person1 != person2) {
			Person firstPerson = null, secondPerson = null;
			for (int i = 0; i < m_lstRelations.size(); i++) {
				firstPerson = m_lstRelations.get(i).getFirstPerson();
				secondPerson = m_lstRelations.get(i).getSecondPerson();
				if (person1 == firstPerson && person2 == secondPerson
						|| person2 == firstPerson && person1 == secondPerson) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public ArrayList<Person> getChildren(Person person) {
		ArrayList<Person> lstChildren = new ArrayList<Person>();
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

	public ArrayList<Person> getParents(Person person) {
		ArrayList<Person> lstParents = new ArrayList<Person>();
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

	public ArrayList<Person> getSiblings(Person person) {
		ArrayList<Person> lstSiblings = new ArrayList<Person>();
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
}
