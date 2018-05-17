package Exception;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: Exceptions for no connection between two adults
 * 
 */
public class NoAvailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoAvailableException() {
		super("At least one of them is already married with another adult.");
	}
}
