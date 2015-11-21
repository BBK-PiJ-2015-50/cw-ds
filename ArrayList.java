public class ArrayList /** implements List */ {
	
	private Object[] array;

	private static int INITIAL_ARRAY_SIZE = 5;

	private int numberOfItems = 0;

	public ArrayList() {
		array = new Object[INITIAL_ARRAY_SIZE];
		numberOfItems;
	}


	public boolean isEmpty() {
		return (numberOfItems == 0) ? true : false;
	}

	public int size() {
		return numberOfItems;
	}

	public ReturnObject get(int index) {

	}

	public ReturnObject remove(int index) {

	}

	public ReturnObject add(int index, Object item) {

	}

	public ReturnObject add(Object item) {

	}
}