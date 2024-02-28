import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filterlist.CircularListWithFilter;
import filterlist.CircularListWithFilterImpl;

public class CircularListWithFilterTest {
    private static final int INITIAL_SIZE = 0;
    private static final int FIRST_ELEMENT = 1;
    private static final int SECOND_ELEMENT = 2;
    private static final int THIRD_ELEMENT = 3;
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

    @Test public void testNextWithZeroElements(){
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test public void testPreviousWithZeroElements(){
        assertEquals(Optional.empty(), circularList.previous());
    }

    @Test public void testNextWithThreeElements(){
        circularList.add(FIRST_ELEMENT);
        circularList.add(SECOND_ELEMENT);
        circularList.add(THIRD_ELEMENT);

        assertAll(
            () -> assertEquals(Optional.of(FIRST_ELEMENT), circularList.next()),
            () -> assertEquals(Optional.of(SECOND_ELEMENT), circularList.next()),
            () -> assertEquals(Optional.of(THIRD_ELEMENT), circularList.next()),
            () -> assertEquals(Optional.of(FIRST_ELEMENT), circularList.next())
        );
    }

    @Test public void testPreviousWithThreeElements(){
        circularList.add(FIRST_ELEMENT);
        circularList.add(SECOND_ELEMENT);
        circularList.add(THIRD_ELEMENT);

        assertAll(
            () -> assertEquals(Optional.of(THIRD_ELEMENT), circularList.previous()),
            () -> assertEquals(Optional.of(SECOND_ELEMENT), circularList.previous()),
            () -> assertEquals(Optional.of(FIRST_ELEMENT), circularList.previous()),
            () -> assertEquals(Optional.of(THIRD_ELEMENT), circularList.previous())
        );
    }
}
