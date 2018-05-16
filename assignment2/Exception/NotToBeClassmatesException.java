package Exception;

/*
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class NotToBeClassmatesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeClassmatesException() {
		super("Trying to make a young child in a classmate relation.");
	}
}
