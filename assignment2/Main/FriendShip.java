
/**
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class FriendShip extends RelationShip {
	
	/* Inherit from RelationShip*/
	
	public FriendShip(Person person1, Person person2) {
		super(person1, person2);
	}

	public Person getFirstPerson() {
		return m_person1;
	}

	public Person getSecondPerson() {
		return m_person2;
	}
}
