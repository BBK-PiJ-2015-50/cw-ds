public class StackImpl extends AbstractStack {

	public StackImpl(List stackImplList) {
		super(stackImplList);
	}

	public boolean isEmpty() {
		return internalList.isEmpty();
	}

	public int size() {
		return internalList.size();
	}

	public void push(Object item) {
		internalList.add(item);
	}

	public ReturnObject top() {
		return internalList.get(size()-1);
	}

	public ReturnObject pop() {
		return internalList.remove(size()-1);
	}
}

/**
 * An implementation of a stack, a data structure of type LIFO (Last
 * In, First Out).
 * 
 * Classes implementing this interface must use a {@see List} as the
 * underlying data structure to store the elements on the stack. 
 * 
 * Not all operations on a stack will always be successful. For
 * example, a programmer may try to pop an element from an empty
 * stack. Since we hace not covered exceptions yet, we need another
 * mechanism to report errors. In order to do that, methods of this
 * list will return a {@see ReturnObject} that will contain either an
 * object or an error value of the right kind (as defined in {@see
 * ErrorMessage}).
 */