public class ReturnObjectImpl implements ReturnObject {
	
	private Object item = null;
	private ErrorMessage error = ErrorMessage.NO_ERROR;

	/** Constructor for ReturnObjectImpl with no error */
	public ReturnObjectImpl(Object item) {
		this.item = item;
	}

	/** Constructor for ReturnObjectImpl with error message */
	public ReturnObjectImpl(ErrorMessage error) {
		this.error = error;
	}
	/** Constructor with item & error supplied */
	public ReturnObjectImpl(Object item, ErrorMessage error) {
		this.item = item;
		this.error = error;
	}

	/** Return whether there has been a error */
	public boolean hasError() {
		return (error != ErrorMessage.NO_ERROR);
	}

	/** Return error message: NO-ERROR if & only if hasError returns false */
	public ErrorMessage getError() {
		return (!hasError()) ? ErrorMessage.NO_ERROR : error;
	}

	/** Return wrapped object or null if there has been an error */
	public Object getReturnValue() {
		return (hasError()) ? null : item;
	}
}