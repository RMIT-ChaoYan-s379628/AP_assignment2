package Main;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: This is the relationship which is an abstract class
 * for instance the relationship only be extended in this class and its subclasses.
 */
public abstract class RelationShip {

    /*
     *Construct two person methord only be used in this class and its subclasses.
     */
    protected Person m_person1 = null, m_person2 = null;

    /* Construction method,including person1 and person2 */

    public RelationShip(Person person1, Person person2) {
        m_person1 = person1;
        m_person2 = person2;
    }

    /* the set method of getFirstPerson */
    public Person getFirstPerson() {
        return m_person1;
    }

    /* the set method of getSecondPerson */
    public Person getSecondPerson() {
        return m_person2;
    }

    public boolean hasPerson(Person person) {
        return m_person1 == person || m_person2 == person;
    }

    /* the set method of getAnotherPerson */
    public Person getAnotherPerson(Person person) {
        if (m_person1 == person) {
            return m_person2;
        } else if (m_person2 == person) {
            return m_person1;
        }
        return null;
    }
}
