package Main;

import java.util.LinkedList;

/**
 * create an adult with specified values
 * 
 * @param strName
 *            name of the adult
 * @param nAge
 *            age of the adult
 * @param strImage
 *            image of the adult
 * @param strStatus
 *            status of the adult
 * @param strSex
 *            sex of the adult
 * @param strState
 *            state of the adult
 */

public class Adult extends Person {

	/* Inherit from Person,include Name and Age */
	public Adult(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
		super(strName, nAge, strImage, strStatus, strSex, strState);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Get a list of children of the adult
	 * 
	 * @return a list of children of the adult
	 */
	public LinkedList<Person> getChildren() {
		RelationShipManager rManager = RelationShipManager.getInstance();
		LinkedList<Person> lstChildren = rManager.getChildren(this);
		return lstChildren;
	}
}
