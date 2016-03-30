package hu.tamas.cardealership.ejbservice.exception;

public class FacadeException extends Exception {
	
	/**
	 * Generated
	 */
	private static final long serialVersionUID = -285108639349188162L;

	public FacadeException(String message) {
		super(message);
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}
}
