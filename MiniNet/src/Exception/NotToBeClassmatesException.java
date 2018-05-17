package Exception;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: Exception for child of classmate relation.
 */
public class NotToBeClassmatesException extends Exception {

	/*
	 * The set of variable unchangeable
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Exceptions of set classmate relation 
	 */
	public NotToBeClassmatesException() {
		super("You cannot make a young child in a classmate relation.");
	}
}
