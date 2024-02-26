import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iteratorlist.CircularListWithIterator;
import iteratorlist.CircularListWithIteratorImpl;

public class CircularListWithIteratorTest {

    private static final int EMPTY_LIST_SIZE = 0;
    private static final int FIRST_ELEMENT = 1;
    private static final int LIST_SIZE_WITH_ONE_ELEMENT = 1;

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

    @Test public void testAddFirstElement(){
        circularList.add(FIRST_ELEMENT);
        assertAll(
            () -> assertEquals(LIST_SIZE_WITH_ONE_ELEMENT, circularList.size()),
            () -> assertFalse(circularList.isEmpty())
        );
    }
}
