public class LinkedList /** implements List */{

	private LinkedListNode head;

	public LinkedList() {
		head = null;
	}

	//public ReturnObject add(int index, Object item);


	public void add(Object item) {
		LinkedListNode newNode = new LinkedListNode(item);

		if (head == null) {
			head = new LinkedListNode(item);
			//return;
		}
		LinkedListNode currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
		newNode.setIndex((currentNode.getIndex())+1);
	}

	public void add(int index, Object item) {
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

	}


}