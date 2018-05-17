package Main;

public abstract class RelationShip {
	protected Person m_person1 = null, m_person2 = null;

	public RelationShip(Person person1, Person person2) {
		m_person1 = person1;
		m_person2 = person2;
	}

	public Person getFirstPerson() {
		return m_person1;
	}

	public Person getSecondPerson() {
		return m_person2;
	}

	public boolean hasPerson(Person person) {
		return m_person1 == person || m_person2 == person;
	}

	public Person getAnotherPerson(Person person) {
		if (m_person1 == person) {
			return m_person2;
		} else if (m_person2 == person) {
			return m_person1;
		}
		return null;
	}
}
