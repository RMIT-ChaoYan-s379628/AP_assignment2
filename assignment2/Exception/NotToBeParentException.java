package Exception;

/*
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class NotToBeParentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeParentException() {
		super("Trying to make younger to be parent.");
	}
}
