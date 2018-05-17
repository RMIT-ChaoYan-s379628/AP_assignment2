package Exception;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: Expections for parents age.
 *
 */
public class NoSuchAgeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchAgeException() {
		super("No such age.");
	}
}