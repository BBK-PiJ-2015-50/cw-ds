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
		}
		LinkedListNode currentNode = head;
		while (currentNode.getNext() != null) {
			currentNode = currentNode.getNext();
		}
		currentNode.setNext(newNode);
	}





}