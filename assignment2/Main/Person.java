package Main;
import java.util.ArrayList;

public class Person {
	protected int m_nAge;
	protected String m_strName, m_strImage, m_strStatus, m_strSex, m_strState;
	private ArrayList<Person> m_lstParent = null, m_lstSibling = null;

	public Person(String strName, int nAge, String strImage, String strStatus,
			String strSex, String strState) {
		m_strName = strName;
		m_nAge = nAge;
		m_strImage = strImage;
		m_strStatus = strStatus;
		m_strSex = strSex;
		m_strState = strState;
		m_lstParent = new ArrayList<Person>();
		m_lstSibling = new ArrayList<Person>();
	}

	public void setImage(String strImage) {
		m_strImage = strImage;
	}

	public void setStatus(String strStatus) {
		m_strStatus = strStatus;
	}

	public void setSex(String strSex) {
		m_strSex = strSex;
	}

	public void setState(String strState) {
		m_strState = strState;
	}

	public int getAge() {
		return m_nAge;
	}

	public String getName() {
		return m_strName;
	}

	public String getImage() {
		return m_strImage;
	}

	public String getStatus() {
		return m_strStatus;
	}

	public String getSex() {
		return m_strSex;
	}

	public String getState() {
		return m_strState;
	}

	public ArrayList<Person> getSiblings() {
		return m_lstSibling;
	}

	public ArrayList<Person> getParents() {
		return m_lstParent;
	}

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

	public void addSibling(Person person) {
		if (null == person)
			return;
		m_lstSibling.add(person);
	}

	public void removeRelation(Person person) {
		m_lstSibling.remove(person);
		m_lstParent.remove(person);
	}

	public void removeRelation(String strName) {
		Person person = getPerson(m_lstParent, strName);
		if (null == person) {
			person = getPerson(m_lstSibling, strName);
			m_lstSibling.remove(person);
		} else {
			m_lstParent.remove(person);
		}
	}

	public static Person getPerson(ArrayList<Person> lstPerson, String strName) {
		if (null == lstPerson)
			return null;
		for (int nIndex = 0; nIndex < lstPerson.size(); nIndex++) {
			if (lstPerson.get(nIndex).equals(strName))
				return lstPerson.get(nIndex);
		}
		return null;
	}
}
