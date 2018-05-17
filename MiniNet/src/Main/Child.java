package Main;

import java.util.ArrayList;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description
 */

public class Child extends Person {
	
	/* Inherit from Person,include Name and Age*/
	
	private ArrayList<Person> m_lstFriends = null, m_lstClassmate = null;

	/* This is the list of every person has his/her friends. */
	public Child(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
		super(strName, nAge, strImage, strStatus, strSex, strState);
		// TODO Auto-generated constructor stub
		m_lstFriends = new ArrayList<Person>();
		m_lstClassmate = new ArrayList<Person>();
	}

	public boolean addFriend(Person person) {
		if (person instanceof Child && 3 >= Math.abs(person.getAge() - m_nAge)) {
			m_lstFriends.add(person);
			Child child = (Child) person;
			child.addFriend(this);
			return true;
		}
		return false;
	}

	public void addClassmate(Person person) {
		if (null != person) {
			m_lstClassmate.add(person);
			Child child = (Child) person;
			child.addClassmate(this);
		}
	}

	public ArrayList<Person> getFriends() {
		return m_lstFriends;
	}

	public ArrayList<Person> getClassmates() {
		return m_lstClassmate;
	}
}
