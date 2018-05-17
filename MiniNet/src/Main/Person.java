package Main;

import java.util.LinkedList;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description Person define a class of all the person in the Net,
 * including Adult and Child.
 * for all Person.
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

    /* the set/get method of the Image */
    public void setImage(String strImage) {
        m_strImage = strImage;
    }

    /* the set/get method of the Status */
    public void setStatus(String strStatus) {
        m_strStatus = strStatus;
    }

    /* the set/get method of the Sex */
    public void setSex(String strSex) {
        m_strSex = strSex;
    }

    /* the set/get method of the State */
    public void setState(String strState) {
        m_strState = strState;
    }

    /* the set/get method of the Age */
    public int getAge() {
        return m_nAge;
    }

    /* the set/get method of the Name */
    public String getName() {
        return m_strName;
    }

    /* the set/get method of the Image*/
    public String getImage() {
        return m_strImage;
    }

    /* the set/get method of the Status */
    public String getStatus() {
        return m_strStatus;
    }

    /* the set/get method of the Sex */
    public String getSex() {
        return m_strSex;
    }

    /* the set/get method of the State */
    public String getState() {
        return m_strState;
    }

    /* the set/get method of the Parents */
    public LinkedList<Person> getParents() {
        return m_lstParent;
    }

    public boolean addParent(Person person) {
        if (null == person || 2 == m_lstParent.size())
            return false;

        /* can't have two fathers or two mothers*/
        for (int nIndex = 0; nIndex < m_lstParent.size(); nIndex++) {
            if (m_lstParent.get(nIndex).getSex().equals(person.getSex()))
                return false;
        }
        m_lstParent.add(person);
        return true;
    }
}
