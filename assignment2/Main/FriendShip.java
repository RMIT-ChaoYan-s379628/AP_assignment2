package Main;
public class FriendShip extends RelationShip {
	public FriendShip(Person person1, Person person2) {
		super(person1, person2);
		// TODO Auto-generated constructor stub
	}

	public Person getFirstPerson() {
		return m_person1;
	}

	public Person getSecondPerson() {
		return m_person2;
	}
}
