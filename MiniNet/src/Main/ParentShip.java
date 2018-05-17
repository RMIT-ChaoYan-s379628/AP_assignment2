package Main;

/**
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class ParentShip extends RelationShip {
	
	/* Inherit from RelationShip*/
	public ParentShip(Person parent, Person child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
	}

	/* The get method of parent name*/
	public Person getParent() {
		return m_person1;
	}

	/* The get method of Child namep*/
	public Person getChild() {
		return m_person2;
	}
}
