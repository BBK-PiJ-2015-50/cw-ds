public class LinkedList /*implements List*/{

	private Node head = null;

	/** LinkedList constructor */
	public LinkedList() {
		this.head = null;
	}

	//public boolean isEmpty();

	public int size() {
		// PLACEHOLDER RETURN - TO BE REPLACED!!!!!!
		return 10;
	}

	//public ReturnObject get(int index);

	public ReturnObject remove(int index) {
		/** test for trying to retrieve an element from an empty data structure */
		if (size() == 0) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}
		/** test for trying to retrieve an element with a negative index
		 * or index greater than or equal to the number of elements
		 * in a data structure */
		if (index < 0 || index >= size()) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		} 
		Node currentNode = head;
		/** if index of element to retrieve is zero, remove head (list start) */
		if (index == 0) {
			head = head.getNext();
			head.setPrevious(null);
			return new ReturnObjectImpl(currentNode.getContent());
		}
		/** move along list until required index is found */
		while (/** (currentNode != null) && */ (index != currentNode.getIndex())) {
				currentNode = currentNode.getNext();
		}
		/** remove element by setting next/previous pointers of elements either side */
		currentNode.getPrevious().setNext(currentNode.getNext());
		if (currentNode.getNext() != null) {
			currentNode.getNext().setPrevious(currentNode.getPrevious());
		}
		return new ReturnObjectImpl(currentNode.getContent());
	}
		
	//public ReturnObject add(int index, Object item);

	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
		}
		Node newNode = new Node(item);
		if (this.head == null) {
			this.head = newNode;
		} else {
			Node currentNode = head;
			while (currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
			newNode.setPrevious(currentNode);
		}
		return new ReturnObjectImpl(null);
	}
		
}