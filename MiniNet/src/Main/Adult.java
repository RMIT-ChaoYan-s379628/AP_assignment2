package Main;

import java.util.LinkedList;

/**
 * @author Chao Yan
 * @date 1/5/17 12:00
 * @description Adult define a class of all the adults in the Net,
 * inherit from Person.
 * for all adults.
 */

public class Adult extends Person {

    /* Inherit from Person,include Name and Age*/
    public Adult(String strName, int nAge, String strImage, String strStatus, String strSex, String strState) {
        super(strName, nAge, strImage, strStatus, strSex, strState);
        // TODO Auto-generated constructor stub
    }

    /* the set/get method of the Children list */
    public LinkedList<Person> getChildren() {
        RelationShipManager rManager = RelationShipManager.getInstance();
        LinkedList<Person> lstChildren = rManager.getChildren(this);
        return lstChildren;
    }
}
