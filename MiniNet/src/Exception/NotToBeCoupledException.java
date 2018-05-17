package Exception;

/**
 * @Author:Meng Gao
 * @Date: 17/5/2018
 * @Introduction: Exception for a couple who is not an adult.
 *
 */
public class NotToBeCoupledException extends Exception {

	/*
	 * The set of variable unchangeable
	 */
	private static final long serialVersionUID = 1L;

	public NotToBeCoupledException() {
		super("At least one of them is not an adult.");
	}
}
