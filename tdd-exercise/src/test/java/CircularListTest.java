import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private static final int EMPTY_LIST = 0;
    private static final int FIRST_ELEMENT = 1;
    private static final int SECOND_ELEMENT = 2;
    private static final int LIST_SIZE_WITH_TWO_ELEMENTS = 2;

    private CircularList circularList;

    @BeforeEach public void createList(){
        circularList = new CircularListImpl();
    }

    @Test public void testIsInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test public void testSizeIsInitiallyZero(){
        assertEquals(EMPTY_LIST, circularList.size());
    }

    @Test public void testAddFirstElement(){
        circularList.add(FIRST_ELEMENT);
        assertFalse(circularList.isEmpty());
    }

    @Test public void testNextOnEmptyListIsEmpty() {
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test public void testPreviousOnEmptyListIsEmpty() {
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test public void testAddTwoElements(){
        circularList.add(FIRST_ELEMENT);
        circularList.add(SECOND_ELEMENT);
        assertAll(
            () -> assertEquals(LIST_SIZE_WITH_TWO_ELEMENTS, circularList.size()), 
            () -> assertFalse(circularList.isEmpty())
        );
    }

    
}
