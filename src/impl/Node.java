/** Class for elements of list*/
public class Node {

	private Object item;
	private Node next;
	private Node previous;

	/** Constructor for a Node element */
	public Node(Object item) {
		this.item = item;
		this.next = null;
		this.previous = null;
	}

	/** Getters & Setters */
	public Object getItem() {
		return item;
	}

	public Node getNext() {
		return next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public void setNext(Node nextNode) {
		this.next = nextNode;
	}

	public void setPrevious(Node previousNode) {
		this.previous = previousNode;
	}
}