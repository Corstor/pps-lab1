package iteratorlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CircularListWithIteratorImpl implements CircularListWithIterator {

    private static final int INITIAL_POSITION = 0;
    private List<Integer> list = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public void add(int firstElement) {
        this.list.add(firstElement);
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return new Iterator<Integer>() {

            private int index = INITIAL_POSITION;

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("");
                }
                int nextValue = list.get(index);
                incrementIndex();
                return nextValue;
            }

            private void incrementIndex() {
                this.index++;
                if (this.index == size()){
                    this.index = INITIAL_POSITION;
                }
            }
            
        };
    }

}
