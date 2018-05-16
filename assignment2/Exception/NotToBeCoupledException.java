
public class NotToBeCoupledException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeCoupledException() {
		super("At least one of them is not an adult.");
	}
}
