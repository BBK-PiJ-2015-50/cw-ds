public class ReturnObjectImpl implements ReturnObject {

	private Object returnValue;
	private ErrorMessage returnError;
	private boolean hasBeenError;

	ReturnObjectImpl (Object returnValue, ErrorMessage returnError, boolean hasBeenError) {
		this.returnValue = returnValue;
		this.returnError = returnError;
		this.hasBeenError = hasBeenError;
	}

	public Object getReturnValue() {
		if (hasBeenError) {
			return null;
		}
		return returnValue;
	}

	public ErrorMessage getError() {
		if (!hasBeenError) {
			return ErrorMessage.NO_ERROR;
		}
		return returnError;
	}
		
	public boolean hasError() {
		return hasBeenError;
	}
}
	/**
*public interface ReturnObject {
	*
	 * Returns whether there has been an error
	 * @return whether there has been an error
	 *
*	public boolean hasError();
*
	**
	 * Returns the error message. 
	 * 
	 * This method must return NO_ERROR if and only if
	 * {@hasError} returns false.
	 * 
	 * @return the error message
	 *
*	public ErrorMessage getError();
*
	**
	 * Returns the object wrapped in this ReturnObject, i.e. the
	 * result of the operation if it was successful, or null if
	 * there has been an error.
	 * 
	 * Note that the output of this method must be null if {@see
	 * hasError} returns true, but the opposite is not true: if
	 * {@see hasError} returns false, this method may or may not
	 * return null.
	 * 
	 * @return the return value from the method or null if there has been an error
	 *
*	public Object getReturnValue();
*}
*/