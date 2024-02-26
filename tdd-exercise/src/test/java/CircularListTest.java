import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int EMPTY_LIST = 0;
    private static final int FIRST_ELEMENT = 1;
    CircularList circularList;

    @BeforeEach public void createList(){
        circularList = new CircularListImpl();
    }

    @Test public void testIsInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test public void testSizeIsInitiallyZero(){
        assertEquals(EMPTY_LIST, circularList.size());
    }

    @Test public void testAddFirstElement() {
        circularList.add(FIRST_ELEMENT);
        assertFalse(circularList.isEmpty());
    }
}
