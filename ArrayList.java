public class ArrayList implements List {
	
	private Object[] array;

	private static int INITIAL_ARRAY_SIZE = 5;

	private int numberOfItems = 0;

	public ArrayList() {
		array = new Object[INITIAL_ARRAY_SIZE];
		int numberOfItems;
	}


	public boolean isEmpty() {
		return (numberOfItems == 0) ? true : false;
	}

	public int size() {
		return numberOfItems;
	}

	public ReturnObject get(int index) {
		ReturnObject check = checkForError(index, size(), isEmpty());
		if (check.hasError()) {
			return check;
		}
		return new ReturnObjectImpl(array[index]);
	}

	public ReturnObject remove(int index) {
		ReturnObject check = checkForError(index, size(), isEmpty());
		if (check.hasError()) {
			return check;
		}
		ReturnObject selectedItem = new ReturnObjectImpl(array[index]);
		for (int i=index; i<numberOfItems; i++) {
			array[i] = array[i+1];
		}
		array[numberOfItems] = null;
		numberOfItems--;
		return selectedItem;
	}

	public ReturnObject add(int index, Object item) {
		ReturnObject check1 = checkForError(index, size(), isEmpty());
		if (check1.hasError()) {
			return check1;
		}
		ReturnObject check2 = checkForError(item);
		if (check2.hasError()) {
			return check2;
		}
		if (numberOfItems == array.length - 1) {
			doubleArraySize();
		}
		for (int i=numberOfItems; i>index; i--) {
			array[i] = array[i-1];
		}
		array[index] = item;
		numberOfItems++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	public ReturnObject add(Object item) {
		return add(numberOfItems, item);
	}

	private ReturnObject checkForError(int index, int size, boolean empty) {
		if (index < 0 || index >= size) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} else if (empty) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	private ReturnObject checkForError(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	public void doubleArraySize() {
		Object[] tempArray = new Object[array.length * 2];
		for (int i=0; i<numberOfItems; i++) {
			tempArray[i] = array[i];
		}
		array = tempArray;
	}
}