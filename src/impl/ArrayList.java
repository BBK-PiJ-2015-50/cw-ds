/**
 * @author Chris Kimberley
 *
 * @see List
 */
public class ArrayList implements List {
	
	private Object[] array;
	private final static int INITIAL_ARRAY_SIZE = 5;
	private int numberOfItems;

	public ArrayList() {
		array = new Object[INITIAL_ARRAY_SIZE];
		numberOfItems = 0;
	}

	public boolean isEmpty() {
		return numberOfItems == 0;
	}

	public int size() {
		return numberOfItems;
	}

	public ReturnObject get(int index) {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		return new ReturnObjectImpl(array[index]);
	}

	public ReturnObject remove(int index) {
		ReturnObject selectedItem = get(index);
        ReturnObject testObj = new ReturnObjectImpl("test string");
        System.out.println(index + " index " + testObj.getReturnValue());
        for (int i=index; i<numberOfItems; i++) {
			array[i] = array[i+1];
		}
		//array[numberOfItems] = null;
		numberOfItems--;
		return selectedItem;
	}

	public ReturnObject add(int index, Object item) {
		if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if (numberOfItems == array.length - 1) {
			doubleArraySize();
		}
		for (int i=numberOfItems; i>index; i--) {
			array[i] = array[i-1];
		}
		array[index] = item;
        System.out.println(numberOfItems);
        numberOfItems++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		if (numberOfItems == array.length - 1) {
			doubleArraySize();
		}
		array[numberOfItems] = item;
		numberOfItems++;
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