import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import filterlist.CircularListWithFilter;
import filterlist.CircularListWithFilterImpl;

public class CircularListWithFilterTest {
    private static final int INITIAL_SIZE = 0;

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

    
}
