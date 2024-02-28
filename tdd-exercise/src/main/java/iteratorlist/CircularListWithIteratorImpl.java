package iteratorlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class CircularListWithIteratorImpl implements CircularListWithIterator {

    private static final int FORWARD_INITIAL_POSITION = 0;
    protected static final int OFFSET_TO_LAST_ELEMENT = 1;
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
        return iterator(true);
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return iterator(false);
    }

    private Iterator<Integer> iterator(boolean isForwardIterator) {
        return new Iterator<Integer>() {
            private final int backwardInitialPosition = size() - OFFSET_TO_LAST_ELEMENT;
            private int index = initialPosition();

            @Override
            public boolean hasNext() {
                return !list.isEmpty();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("The list is empty");
                }
                int valueToReturn = list.get(index);
                updateIndex();
                return valueToReturn;
            }

            private void updateIndex() {
                if (this.index == lastPosition()){
                    this.index = initialPosition();
                } else if (isForwardIterator) {
                    incrementIndex();
                } else {
                    decrementIndex();
                }
            }

            private int lastPosition() {
                return isForwardIterator ? backwardInitialPosition : FORWARD_INITIAL_POSITION;
            }

            private int initialPosition() {
                return isForwardIterator ? FORWARD_INITIAL_POSITION : backwardInitialPosition;
            }

            private void incrementIndex() {
                this.index++;
            }

            private void decrementIndex() {
                this.index--;
            }
        };
    }
}
