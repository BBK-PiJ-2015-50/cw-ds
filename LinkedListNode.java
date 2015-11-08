public class LinkedListNode {
	private Object item;
	private LinkedListNode next;

	public LinkedListNode(Object item) {
		this.item = item;
		next = null;
	}

	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode nextNode) {
		next = nextNode;
	}
}