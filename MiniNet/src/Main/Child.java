package Main;

import java.util.ArrayList;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description Child define a class of all the children in the Net, inherit
 *              from Person. for all children.
 */

public class Child extends Person {

	/**
	 * create a child with specified values
	 * 
	 * @param strName
	 *            name of the child
	 * @param nAge
	 *            age of the child
	 * @param strImage
	 *            image of the child
	 * @param strStatus
	 *            status of the child
	 * @param strSex
	 *            sex of the child
	 * @param strState
	 *            state of the child
	 */
	private ArrayList<Person> m_lstFriends = null, m_lstClassmate = null;

	/* This is the list of every person has his/her friends. */
	public Child(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
		super(strName, nAge, strImage, strStatus, strSex, strState);
		// TODO Auto-generated constructor stub
		m_lstFriends = new ArrayList<Person>();
		m_lstClassmate = new ArrayList<Person>();
	}

	/**
	 * Add a new Friend to this child
	 * 
	 * @param person
	 *            new friend
	 * @return true if they can be friends otherwise return false
	 */
	public boolean addFriend(Person person) {
		if (person instanceof Child && 3 >= Math.abs(person.getAge() - m_nAge)) {
			m_lstFriends.add(person);
			Child child = (Child) person;
			child.addFriend(this);
			return true;
		}
		return false;
	}

	/**
	 * add new classmate to the child
	 * 
	 * @param person
	 *            new classmate
	 */
	public void addClassmate(Person person) {
		if (null != person) {
			m_lstClassmate.add(person);
			Child child = (Child) person;
			child.addClassmate(this);
		}
	}

	/**
	 * Get list of friends of the child
	 * 
	 * @return List of friends of the child
	 */
	public ArrayList<Person> getFriends() {
		return m_lstFriends;
	}

	/**
	 * Get list of classmates of the child
	 * 
	 * @return List of classmates of the child
	 */
	public ArrayList<Person> getClassmates() {
		return m_lstClassmate;
	}
}
