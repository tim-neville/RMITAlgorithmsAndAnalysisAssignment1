import java.io.PrintStream;
import java.util.*;

/**
 * Hasp table/map implementation of a multiset.  Implements Multiset  abstract class.
 * 
 * @param T Type of elements that the multiset can hold.
 * 
 * @author jkcchan
 */
public class HashMultiset<T> extends Multiset<T>
{
	/** Internal treemap used to implement multiset semantics. The mapped value stores the number of instances of each element. */
	protected HashMap<T, Integer> mMap;


	public HashMultiset() {
		mMap = new HashMap<T, Integer>();
	} // end of HashMultiset()


	public void add(T item) {
		// if map already contains item, we add to associated linkedlist
		if (mMap.containsKey(item)) {
			int count = mMap.get(item);
			mMap.put(item, count+1);
		}
		// else new item in multiset
		else {
			mMap.put(item, 1);
		}
	} // end of add()


	public int search(T item) {
		int count = 0;
		
		if (mMap.containsKey(item)) {
			count = mMap.get(item);
		}

		return count;
	} // end of add()


	public void removeOne(T item) {
		if (mMap.containsKey(item)) {
			int count = mMap.get(item);
			if (count == 1) {
				mMap.remove(item);
			}
			else {
				mMap.put(item, count-1);
			}
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		if (mMap.containsKey(item)) {
			mMap.remove(item);
		}
	} // end of removeAll()


	public void print(PrintStream out) {
		Iterator mit = mMap.entrySet().iterator();
		while (mit.hasNext()) {
			// need to suppress warning because of we are casting parameterised types
			@SuppressWarnings("unchecked")
			Map.Entry<T, Integer> entry = (Map.Entry<T, Integer>) mit.next();
			out.println(entry.getKey() + printDelim + entry.getValue());
		}
	} // end of print()

} // end of class HashMultiset
