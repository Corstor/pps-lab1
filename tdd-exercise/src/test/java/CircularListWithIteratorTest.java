import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iteratorlist.CircularListWithIterator;
import iteratorlist.CircularListWithIteratorImpl;

public class CircularListWithIteratorTest {

    private static final int EMPTY_LIST_SIZE = 0;
    private CircularListWithIterator circularList;

    @BeforeEach public void testCreateCircularList(){
        circularList = new CircularListWithIteratorImpl();
    }

    @Test public void testListIsInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test public void testListSizeIsInitiallyZero(){
        assertEquals(EMPTY_LIST_SIZE, circularList.size());
    }
}
