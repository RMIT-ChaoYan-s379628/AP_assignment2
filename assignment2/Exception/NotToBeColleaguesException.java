package Exception;

/**
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class NotToBeColleaguesException extends Exception {

	/*
	 * The set of variable unchangeable
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeColleaguesException() {
		super("Trying to connect a child in a colleague relation.");
	}
}
