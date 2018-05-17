package Main;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: This is the relationship which is an abstract class for
 *                instance the relationship only be extended in this class and
 *                its subclasses.
 */
public abstract class RelationShip {
	protected Person m_person1 = null, m_person2 = null;

	/**
	 * Create new relationship between person1 and person2
	 * 
	 * @param person1
	 *            one person in this relationship
	 * @param person2
	 *            the other person in this relationship
	 */
	public RelationShip(Person person1, Person person2) {
		m_person1 = person1;
		m_person2 = person2;
	}

	/**
	 * Get first person in this relationship
	 * 
	 * @return first person in this relationship
	 */
	public Person getFirstPerson() {
		return m_person1;
	}

	/**
	 * Get second person in this relationship
	 * 
	 * @return second person in this relationship
	 */
	public Person getSecondPerson() {
		return m_person2;
	}

	/**
	 * Check if this relationship contains the specified person
	 * 
	 * @param person
	 *            person to check
	 * @return true if the person is contained otherwise return false
	 */
	public boolean hasPerson(Person person) {
		return m_person1 == person || m_person2 == person;
	}

	/**
	 * Get the other person in this relationship
	 * 
	 * @param person
	 *            one person in this relationship
	 * @return the other person in this relationship
	 */
	public Person getAnotherPerson(Person person) {
		if (m_person1 == person) {
			return m_person2;
		} else if (m_person2 == person) {
			return m_person1;
		}
		return null;
	}
}
