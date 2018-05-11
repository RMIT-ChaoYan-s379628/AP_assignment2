
public class ParentShip extends RelationShip {
	public ParentShip(Person parent, Person child) {
		super(parent, child);
		// TODO Auto-generated constructor stub
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
