package Main;

/**
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: FriendShip define a class of all the friendship in the Net,
 * inherit from Relationship.
*
*/
public class FriendShip extends RelationShip {
	
	/* Inherit from RelationShip*/
	public FriendShip(Person person1, Person person2) {
		super(person1, person2);
		// TODO Auto-generated constructor stub
	}

	/* The get method of FirstPerson name*/
	public Person getFirstPerson() {
		return m_person1;
	}

	/* The get method of SecondPerson name*/
	public Person getSecondPerson() {
		return m_person2;
	}
}
