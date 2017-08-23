import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T>
{
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

	public SortedLinkedListMultiset() {
	}
	
	
	public void add(T item) throws NullPointerException {
	    if (item == null) throw new NullPointerException("null item passed into add function");

	    Node<T> newNode = new Node<>(item, null, null);

        if (isEmpty()) {
            head = newNode;
        } else {
            /** needs to be sorted */

            newNode.setPrevious(tail);
            tail.next = newNode;
        }
        tail = newNode;
	}
	
	
	public int search(T item) {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
	} // end of add()
	
	
	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()
	
	
	public void print(PrintStream out) {
		// Implement me!
	} // end of print()

    //Utility Methods
    private boolean isEmpty() {
	    return size == 0;
    }

    //Nested Node class
	private class Node<T> {
        private T element;
        private Node<T> previous;
        private Node<T> next;

        Node(T element, Node<T> previous, Node<T> next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
} // end of class SortedLinkedListMultiset