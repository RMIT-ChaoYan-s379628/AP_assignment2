
public class NotToBeColleaguesException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeColleaguesException() {
		super("Trying to connect a child in a colleague relation.");
	}
}
