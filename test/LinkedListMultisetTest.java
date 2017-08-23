import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by timneville on 23/8/17.
 */
public class LinkedListMultisetTest {
    LinkedListMultiset linkedListMultiset;

    @Before
    public void setUp() throws Exception {
        linkedListMultiset = new LinkedListMultiset();
    }

    @Test
    public void listContainsElementAfterAdding() throws Exception {
        assertEquals(0, linkedListMultiset.search("Fortune"));

        linkedListMultiset.add("Fortune");

        assertEquals("contains 1 Fortune", 1, linkedListMultiset.search("Fortune"));

        linkedListMultiset.add("Fortune");

        assertEquals("contains 2 Fortune", 2, linkedListMultiset.search("Fortune"));

        linkedListMultiset.add("Fortune");
        linkedListMultiset.add("Fortune");
        linkedListMultiset.add("Chocolate");

        assertEquals("contains 4 Fortune", 4, linkedListMultiset.search("Fortune"));
        assertEquals("contains 1 Chocolate", 1, linkedListMultiset.search("Chocolate"));
    }

    @Test
    public void emptyListReturnsCorrectElementCountAfterRemoveOne() throws Exception {
        linkedListMultiset.add("Hops");
        linkedListMultiset.removeOne("Hops");

        assertEquals("Should be no Hops",0, linkedListMultiset.search("Hops"));

    }

    @Test
    public void emptyListReturnsZeroElementCountAfterRemoveAll() throws Exception {
        linkedListMultiset.add("Fortune");
        linkedListMultiset.add("Fortune");
        linkedListMultiset.add("Fortune");
        linkedListMultiset.add("Fortune");
        linkedListMultiset.add("Fortune");

        assertEquals(5, linkedListMultiset.search("Fortune"));

        linkedListMultiset.removeAll("Fortune");

        assertEquals(0, linkedListMultiset.search("Fortune"));
    }

}