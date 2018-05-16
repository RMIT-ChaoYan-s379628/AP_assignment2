
/**
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class ParentShip extends RelationShip {
	
	
	
	public ParentShip(Person parent, Person child) {
		super(parent, child);
	}
	
	public Person getParent()
	{
		return m_person1;
	}
	
	public Person getChild()
	{
		return m_person2;
	}
}
