package Main;
import java.util.ArrayList;


public class Adult extends Person{
	
	public Adult(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
		super(strName, nAge, strImage, strStatus, strSex, strState);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Person> getChildren()
	{
		RelationShipManager rManager = RelationShipManager.getInstance();
		ArrayList<Person> lstChildren = rManager.getChildren(this);
		return lstChildren;
	}
}
