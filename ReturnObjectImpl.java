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
