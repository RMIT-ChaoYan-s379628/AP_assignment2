package Exception;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: Exception for child's colleague relation.
 *
 */
public class NotToBeColleaguesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeColleaguesException() {
		super("Trying to connect a child in a colleague relation.");
	}
}