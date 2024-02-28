import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filterlist.CircularListWithFilter;
import filterlist.CircularListWithFilterImpl;

public class CircularListWithFilterTest {
    private static final int INITIAL_SIZE = 0;
    private static final int FIRST_ELEMENT = 1;
    private static final int SECOND_ELEMENT = 2;
    private static final int SIZE_WITH_TWO_ELEMENTS = 2;

    private CircularListWithFilter circularList;

    @BeforeEach public void createCircularListWithFilter(){
        circularList = new CircularListWithFilterImpl();
    }

    @Test public void testListIsInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test public void testSizeIsInitiallyZero(){
        assertEquals(INITIAL_SIZE, circularList.size());
    }

    @Test public void testAdd(){
        circularList.add(FIRST_ELEMENT);
        circularList.add(SECOND_ELEMENT);

        assertAll(
            () -> assertEquals(SIZE_WITH_TWO_ELEMENTS, circularList.size()),
            () -> assertFalse(circularList.isEmpty())
        );
    }
}
