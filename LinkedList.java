public class LinkedList /** implements List */{

	private LinkedListNode head;

	public LinkedList() {
		head = null;
	}

	//public ReturnObject add(int index, Object item);


	public void add(Object item) {
		LinkedListNode newNode = new LinkedListNode(item);
		if (head == null) {
			head = newNode;
			//return;
		}
		LinkedListNode currentNode = head;
		newNode.setIndex(1);
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
			newNode.setIndex(newNode.getIndex() + 1);
		}
		currentNode.setNext(newNode);

	}

	public void add(int index, Object item) {
		LinkedListNode newNode = new LinkedListNode(index, item);

		LinkedListNode currentNode = head;
		if (currentNode != null) {

		}

		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		newNode.setNext(currentNode.getNext());
		currentNode.setNext(newNode);
	}





}