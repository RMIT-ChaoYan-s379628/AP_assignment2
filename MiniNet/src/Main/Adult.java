package Main;

import java.util.LinkedList;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description 
 */

public class Adult extends Person {

	/* Inherit from Person,include Name and Age*/
	public Adult(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
		super(strName, nAge, strImage, strStatus, strSex, strState);
		// TODO Auto-generated constructor stub
	}

	public LinkedList<Person> getChildren() {
		RelationShipManager rManager = RelationShipManager.getInstance();
		LinkedList<Person> lstChildren = rManager.getChildren(this);
		return lstChildren;
	}
}
