package Exception;

/*
 
* @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class NoParentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoParentException() {
		super("A child or young child has no parent or has only one parent.");
	}
}
