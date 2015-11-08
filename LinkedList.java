public class LinkedList /** implements List */{

	private LinkedListNode head;
	private static int nodeCount;

	public LinkedList() {
		head = null;
	}


	public ReturnObject add(Object item) {
		if (item == null) {
			return new ReturnObjectImpl (null, ErrorMessage.INVALID_ARGUMENT, true);
		}
		addOneToNodeCount();
		LinkedListNode newNode = new LinkedListNode(item);
		if (head == null) {
			head = new LinkedListNode(item);
			ReturnObject instance1 = new ReturnObjectImpl (null, ErrorMessage.NO_ERROR, false);
			return instance1;
		}
		LinkedListNode currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		newNode.setIndex((currentNode.getIndex())+1);
		return new ReturnObjectImpl (null, ErrorMessage.NO_ERROR, false);
	}

	public ReturnObject add(int index, Object item) {
		if (item == null) {
			return new ReturnObjectImpl (null, ErrorMessage.INVALID_ARGUMENT, true);
		}
		addOneToNodeCount();
		LinkedListNode newNode = new LinkedListNode(item);
		newNode.setIndex(index);
		LinkedListNode currentNode = head;
		/**if (currentNode != null) {

		}*/
		for (int i=1; i<index; i++) {
			if (currentNode.getNext() == null) {
				break;
			}
			currentNode = currentNode.getNext();
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
		currentNode = newNode;
		while (currentNode.getNext() != null) {
			currentNode.getNext().setIndex(currentNode.getIndex()+1);
			currentNode = currentNode.getNext();
		}
		return new ReturnObjectImpl (null, ErrorMessage.NO_ERROR, false);
	}


	private static void addOneToNodeCount() {
		nodeCount++;
	}

	private static void takeOneFromNodeCount () {
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