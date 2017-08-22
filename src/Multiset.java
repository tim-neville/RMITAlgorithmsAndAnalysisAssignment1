import java.io.PrintStream;
import java.util.*;

/**
 * Abstract class for a multiset.  Your implmentation should extend this abstract class and implement all the abstract methods.
 *
 * @param T Type of elements that the multiset can hold.
 * 
 * @author jkcchan
 */
public abstract class  Multiset<T>
{
	/** Delimiter string for print operation. */
	protected static final String printDelim = " | ";

	
	/** 
	 * Add an element into multiset. 
	 * 
	 * @param item Element to add.
	 */
	public abstract void add(T item);

	
	/**
	 * Searches for an element in the multiset.
	 * 
	 * @param item Element to search for.
	 * @return The number of instance of the element in the multiset.  If element is not in the multiset, return 0.
	 */
	public abstract int search(T item);

	
	/**
	 * Remove one instance of element from the multiset.  If element doesn't exist, method just returns.
	 * 
	 * @param item Element to remove. 
	 */
	public abstract void removeOne(T item);
	
	
	/**
	 * Remove all instances of element from the multiset.  If element doesn't exist, method just returns.
	 * 
	 * @param item Element to remove. 
	 */
	public abstract void removeAll(T item);

	
	/**
	 * Prints out all the elements and the number of instances of each to 'out' PrintStream.
	 * 
	 * @param out PrintStream to print out to.
	 */
	public abstract void print(PrintStream out);
} // end of abstract class Multiset
