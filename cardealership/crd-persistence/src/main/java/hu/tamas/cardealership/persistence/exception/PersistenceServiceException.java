package hu.tamas.cardealership.persistence.exception;

public class PersistenceServiceException extends Exception {

	/**
	 * Generated
	 */
	private static final long serialVersionUID = -1603002557001918438L;

	public PersistenceServiceException(String message) {
		super(message);
	}

	public PersistenceServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
