package iteratorlist;

import java.util.Iterator;

public interface CircularListWithIterator {

    boolean isEmpty();

    int size();

    void add(int firstElement);

	Iterator<Integer> forwardIterator();

}
