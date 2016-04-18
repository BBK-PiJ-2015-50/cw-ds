/**
 * @author Chris Kimberley
 *
 * @see ReturnObject
 */
public class ReturnObjectImpl implements ReturnObject {
	
	private Object item;
	private ErrorMessage error;

	/** Constructor for ReturnObjectImpl with no error */
	public ReturnObjectImpl(Object item) {
		this.item = item;
	}

	/** Constructor for ReturnObjectImpl with error message */
	public ReturnObjectImpl(ErrorMessage error) {
		this.error = error;
	}

	/** Return whether there has been a error */
	public boolean hasError() {
		return (error != ErrorMessage.NO_ERROR);
	}

	/** Return error message: NO-ERROR if & only if hasError returns false */
	public ErrorMessage getError() {
		return hasError() ? error : ErrorMessage.NO_ERROR;
	}

	/** Return wrapped object or null if there has been an error */
	public Object getReturnValue() {
		return hasError() ? null : item;
	}

    public String toString() {
        return (String) item;
    }
}