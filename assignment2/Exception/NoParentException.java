
public class NoParentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoParentException() {
		super("A child or young child has no parent or has only one parent.");
	}
}
