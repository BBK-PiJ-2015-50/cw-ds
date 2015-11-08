public class LinkedList implements List {

	private LinkedListNode head;
	private static int nodeCount;

	public LinkedList() {
		head = new LinkedListNode(null);
		nodeCount = 0;
	}


	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT, true);
		}
		LinkedListNode newNode = new LinkedListNode(item);
		
		LinkedListNode currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		addOneToNodeCount();
		newNode.setIndex(getNodeCount()-1);
		return new ReturnObjectImpl(null, ErrorMessage.NO_ERROR, false);
	}

	public ReturnObject add(int index, Object item) {
		if (item == null) {
			return new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT, true);
		}
		LinkedListNode newNode = new LinkedListNode(item);
		newNode.setIndex(index);
		LinkedListNode currentNode = head;
		
		for (int i=1; i<=index; i++) {
			if (currentNode.getNext() == null) {
				return new ReturnObjectImpl(null, ErrorMessage.INVALID_ARGUMENT, true);
			}
			currentNode = currentNode.getNext();
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		currentNode = newNode;
		currentNode.setIndex(index);
		for (int i=index+1;i<=getNodeCount();i++) {
			currentNode = currentNode.getNext();
			currentNode.setIndex(i); 
		}
		
		addOneToNodeCount();
		return new ReturnObjectImpl(null, ErrorMessage.NO_ERROR, false);
	}


	public ReturnObject get(int index) {
		if (index < 0 || index > size()) {
			return new ReturnObjectImpl (null, ErrorMessage.INDEX_OUT_OF_BOUNDS, true);
		}
		LinkedListNode currentNode = head;
			for (int i=0;i <= index;i++) {
				if (currentNode.getNext() == null) {
					return new ReturnObjectImpl (null, ErrorMessage.INDEX_OUT_OF_BOUNDS, true);
				}
				currentNode = currentNode.getNext();
			}
			return new ReturnObjectImpl(currentNode.getContent(), ErrorMessage.NO_ERROR, false);
	}


	public ReturnObject remove(int index) {
		if (index < 0 || index > size()) {
			return new ReturnObjectImpl (null, ErrorMessage.INDEX_OUT_OF_BOUNDS, true);
		}
		LinkedListNode currentNode = head;
		for (int i=0;i < index;i++) {
			if (currentNode.getNext() == null) {
				return new ReturnObjectImpl (null, ErrorMessage.INDEX_OUT_OF_BOUNDS, true);
			}
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(currentNode.getNext().getNext());
		currentNode = currentNode.getNext().getNext();
		
		takeOneFromNodeCount();
		while (currentNode.getNext() != null) {

		}
		for (int i=index+1;i<(getNodeCount()-1);i++) {
			currentNode = currentNode.getNext();
			currentNode.setIndex(i); 
		}
		
		return new ReturnObjectImpl (currentNode.getContent(), ErrorMessage.NO_ERROR, false);
	}


	private static void addOneToNodeCount() {
		nodeCount++;
	}

	private static void takeOneFromNodeCount() {
		nodeCount--;
	}

	private static int getNodeCount() {
		return nodeCount;
	}

	public int size() {
		return getNodeCount();
	}

	public boolean isEmpty() {
		boolean empty = (getNodeCount() == 0)? true : false;
		return empty;
	}


}