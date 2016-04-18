public class LinkedList implements List {

	private Node head = null;
	private int numberOfItems = 0;
	private ReturnObject selectedItem;

	/** LinkedList constructor */
	public LinkedList() {
		this.head = null;
	}

	public boolean isEmpty() {
		return (numberOfItems == 0);
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
		Node currentNode = head;
		for (int i=0; i<index; i++) {
			currentNode = currentNode.getNext();
		}
		return new ReturnObjectImpl(currentNode.getItem());
	}
	
	public ReturnObject remove(int index) {
		if (isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		/** remove head */
		Node currentNode = head;
		if (index == 0) {
			selectedItem = new ReturnObjectImpl(head.getItem());
			head = head.getNext();
			head.setPrevious(null);
			numberOfItems--;
			return selectedItem;
		}
		/** remove end of list */
		if (index == (size()-1)) {
			for (int i=0; i<index; i++) {
				if (i == index-1) {
					selectedItem = new ReturnObjectImpl(currentNode.getNext());
					currentNode.setNext(currentNode.getNext().getNext());
					numberOfItems--;
					return selectedItem;
				}
				currentNode = currentNode.getNext();
			}
		}
		/** remove elements from body of list */
		for (int i=0; i<index; i++) {
			if (i == index-1) {
				selectedItem = new ReturnObjectImpl(currentNode.getNext());
				currentNode.setNext(currentNode.getNext().getNext());
				currentNode.getNext().getNext().setPrevious(currentNode);
				numberOfItems--;
				return selectedItem;
			}
			currentNode = currentNode.getNext();
		}
		return selectedItem;
	}

	public ReturnObject add(int index, Object item) {
		if (index < 0 || index > size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		Node newNode = new Node(item);
		Node currentNode = head;
		/** add element to empty list */
		if (isEmpty()) {
			head = newNode;
			numberOfItems++;
			return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
		}
		/** add element to head in a non-empty list */
		if (index == 0) {
			currentNode = head;
			head = newNode;
			head.setNext(currentNode);
			currentNode.setPrevious(head);	
		}
		/** add elements to other positions */
		for (int i=0; i<index; i++) {
			if (i == (index-1)) {
				newNode.setPrevious(currentNode);
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				if (currentNode.getNext().getNext() != null) {
					currentNode.getNext().getNext().setPrevious(newNode);
				}
			}
			currentNode = currentNode.getNext();
		}
		numberOfItems++;
		return new ReturnObjectImpl(ErrorMessage.NO_ERROR);
	}

	public ReturnObject add(Object item) {
		return add(numberOfItems, item);
	}

}