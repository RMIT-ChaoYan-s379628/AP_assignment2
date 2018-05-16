package Exception;

/**
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class NotToBeFriendsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeFriendsException() {
		super("Trying to make an adult and a child friend or connect two " + "children with an age gap larger than 3");
	}
}
