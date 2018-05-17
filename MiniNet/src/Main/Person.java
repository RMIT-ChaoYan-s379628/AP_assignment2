package Main;

import java.util.LinkedList;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description Person define a class of all the person in the Net, including
 *              Adult and Child. for all Person.
 */

public class Person {
	protected int m_nAge;
	protected String m_strName, m_strImage, m_strStatus, m_strSex, m_strState;

	/* This is the list of every person has his/her friends. */
	private LinkedList<Person> m_lstParent = null;

	/* Construction method,including name and age to construct a person */
	public Person(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
		m_strName = strName;
		m_nAge = nAge;
		m_strImage = strImage;
		m_strStatus = strStatus;
		m_strSex = strSex;
		m_strState = strState;
		m_lstParent = new LinkedList<>();
	}

	/**
	 * Set new image to the person
	 * 
	 * @param strImage
	 *            new image of the person
	 */
	public void setImage(String strImage) {
		m_strImage = strImage;
	}

	/**
	 * set new status to the person
	 * 
	 * @param strStatus
	 *            new status of the person
	 */
	public void setStatus(String strStatus) {
		m_strStatus = strStatus;
	}

	/**
	 * set new sex to the person
	 * 
	 * @param strSex
	 *            new sex of the person
	 */
	public void setSex(String strSex) {
		m_strSex = strSex;
	}

	/**
	 * set new state to the person
	 * 
	 * @param strState
	 *            new state of the person
	 */
	public void setState(String strState) {
		m_strState = strState;
	}

	/**
	 * Get the age of the person
	 * 
	 * @return the age of the person
	 */
	public int getAge() {
		return m_nAge;
	}

	/**
	 * Get the name of the person
	 * 
	 * @return the name of the person
	 */
	public String getName() {
		return m_strName;
	}

	/**
	 * Get the image path of the person
	 * 
	 * @return the image path of the person
	 */
	public String getImage() {
		return m_strImage;
	}

	/**
	 * Get status of the person
	 * 
	 * @return status of the person
	 */
	public String getStatus() {
		return m_strStatus;
	}

	/**
	 * Get sex of the person
	 * 
	 * @return sex of the person
	 */
	public String getSex() {
		return m_strSex;
	}

	/**
	 * Get state of the person
	 * 
	 * @return state of the person
	 */
	public String getState() {
		return m_strState;
	}

	/**
	 * Get all parents of the person
	 * 
	 * @return list of Person who is parent of the person
	 */
	public LinkedList<Person> getParents() {
		return m_lstParent;
	}

	/**
	 * Set parent to the person
	 * 
	 * @param person
	 *            Person who is a parent of the person
	 * @return true if set successfully otherwise return false
	 */
	public boolean addParent(Person person) {
		if (null == person || 2 == m_lstParent.size())
			return false;
		// can't have two fathers or two mothers
		for (int nIndex = 0; nIndex < m_lstParent.size(); nIndex++) {
			if (m_lstParent.get(nIndex).getSex().equals(person.getSex()))
				return false;
		}
		m_lstParent.add(person);
		return true;
	}
}
