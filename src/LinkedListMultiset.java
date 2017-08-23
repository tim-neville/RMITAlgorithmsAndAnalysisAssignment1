import java.io.PrintStream;
import java.util.Collection;

public class LinkedListMultiset<T> extends Multiset<T>
{
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;

	public LinkedListMultiset() {}
	public LinkedListMultiset(Collection<? extends T> collection) {
	    for (T each : collection) {
	        add(each);
        }
    }


	public void add(T item) {
        validateItem(item);

        Node<T> searchNode = findNodeContaining(item);

        if (searchNode == null) { //Add to the end
            Node<T> newNode = new Node<>(item, null, null);
            newNode.setCount(1);

            if (isEmpty()) {
                head = newNode;
            } else {
                newNode.setPrevious(tail);
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        } else {
            int count = searchNode.getCount();
            searchNode.setCount(++count);
            size++;
        }
	}
	
	
	public int search(T item) {
        validateItem(item);

        Node<T> searchNode = findNodeContaining(item);
        if (searchNode == null) {
            return 0;
        } else {
            return searchNode.getCount();
        }
	}
	
	
	public void removeOne(T item) {
        validateItem(item);

        Node<T> searchNode = findNodeContaining(item);
        if (searchNode != null && searchNode.getCount() == 1) {
            searchNode.previous.setNext(searchNode.next);
            size--;
        } else {
            int count = searchNode.getCount();
            searchNode.setCount(--count);
            size--;
        }
	}
	
	
	public void removeAll(T item) {
        validateItem(item);

        Node<T> searchNode = findNodeContaining(item);

        if (searchNode != null) {
            size -= searchNode.getCount();
            searchNode.previous.setNext(searchNode.next);
        }
	}
	
	
	public void print(PrintStream out) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            out.println("Current element: " + currentNode.element);
            out.println("Count: " + currentNode.getCount());
            currentNode = currentNode.getNext();
        }
	}


	//Utility Methods
	private boolean isEmpty() {
		return size == 0;
	}

	private Node<T> findNodeContaining(T item) throws NullPointerException {
	    Node<T> currentNode = head;

	    while (currentNode != null) {
	        if (currentNode.getElement().equals(item)) {
	            return currentNode;
            }
	        currentNode = currentNode.getNext();
        }
        return null;
    }


	private void validateItem(T item) throws NullPointerException {
        if (item == null) throw new NullPointerException("null item passed into add function");
    }

	//Nested Node class
	private class Node<T> {
		private T element;
		private Node<T> previous;
		private Node<T> next;
		private int count = 0;

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

        public int getCount() {
            return count;
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

        public void setCount(int count) {
            this.count = count;
        }
    }
} // end of class LinkedListMultiset