package Exception;

/**
 * @Author:Meng Gao	
* @Date: 17/5/2018
* @Introduction: 
*
*/
public class NoParentException extends Exception {

	/*
	 * The set of variable unchangeable
	 */
	private static final long serialVersionUID = 1L;

	
	/*
	 * Exceptions of a child with no parent or only one parent
	 */
	public NoParentException() {
		super("A child or young child has no parent or has only one parent.");
	}
}
