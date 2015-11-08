public class LinkedListNode {

	private Object item;
	private LinkedListNode nextNode;
	private int index;

	public LinkedListNode(Object item) {
		this.item = item;
		nextNode = null;
		index = 0;
	}

	public LinkedListNode(int index, Object item) {
		this.item = item;
		nextNode = null;
		this.index = index;
	}

	public LinkedListNode getNext() {
		return nextNode;
	}

	public void setNext(LinkedListNode nextNode) {
		this.nextNode = nextNode;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}