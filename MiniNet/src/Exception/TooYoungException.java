package Exception;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: Exception for young child relation.
 *
 */
public class TooYoungException extends Exception {

	/*
	 * The set of variable unchangeable
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Exceptions of making friends with young child.
	 */
	public TooYoungException() {
		super("You cannot make friend with a young child");
	}
}
