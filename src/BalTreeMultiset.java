import java.io.PrintStream;
import java.util.*; 

/**
 * Balanced tree implementation of a multiset.  Implements Multiset abstract class.
 *
 * @param T Type of elements that the multiset can hold.
 * 
 * @author jkcchan
 */
public class BalTreeMultiset<T> extends Multiset<T>
{
	/** Internal treemap used to implement multiset semantics. The mapped value stores the number of instances of each element. */
	protected TreeMap<T, Integer> mTree;


	public BalTreeMultiset() {
		mTree = new TreeMap<T, Integer>();
	} // end of BalTreeMultiset()


	public void add(T item) {
		// if map already contains item, we add to associated linkedlist
		if (mTree.containsKey(item)) {
			int count = mTree.get(item);
			mTree.put(item, count+1);
		}
		// else new item in multiset
		else {
			mTree.put(item, 1);
		}
	} // end of add()


	public int search(T item) {
		int count = 0;
		
		if (mTree.containsKey(item)) {
			count = mTree.get(item);
		}

		return count;
	} // end of add()


	public void removeOne(T item) {
		if (mTree.containsKey(item)) {
			int count = mTree.get(item);
			if (count == 1) {
				mTree.remove(item);
			}
			else {
				mTree.put(item, count-1);
			}
		}
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		if (mTree.containsKey(item)) {
			mTree.remove(item);
		}
	} // end of removeAll()


	public void print(PrintStream out) {
		Iterator mit = mTree.entrySet().iterator();
		while (mit.hasNext()) {
			// need to suppress warning because of we are casting parameterised types
			@SuppressWarnings("unchecked")
			Map.Entry<T, Integer> entry = (Map.Entry<T, Integer>) mit.next();
			out.println(entry.getKey() + printDelim + entry.getValue());
		}
	} // end of print()

} // end of class BalTreeMultiset
