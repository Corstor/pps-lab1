package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private static final int FIRST_ELEMENT = 0;
    private static final int OFFSET_LAST_ELEMENT = 1;
    private static final int INDEX_STARTING_VALUE = -1;

    private final List<Integer> list = new ArrayList<>();
    private int index = INDEX_STARTING_VALUE;

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if (isLastElement()) {
            resetIndex();
        } else {
            incrementIndex();
        }
        return getElement();
    }

    private boolean isLastElement() {
        return index == lastElementIndex();
    }

    private int lastElementIndex() {
        return this.size() - OFFSET_LAST_ELEMENT;
    }

    private void resetIndex() {
        this.index = FIRST_ELEMENT;
    }

    private void incrementIndex() {
        this.index++;
    }

    @Override
    public Optional<Integer> previous() {
        if (isFirstElement()) {
            setIndexToLastElement();
        } else {
            decrementIndex();
        }
        return getElement();
    }

    private boolean isFirstElement() {
        return index == FIRST_ELEMENT || index == INDEX_STARTING_VALUE;
    }

    private void setIndexToLastElement() {
        this.index = this.size() - OFFSET_LAST_ELEMENT;
    }

    private void decrementIndex() {
        this.index--;
    }

    private Optional<Integer> getElement() {
        Optional<Integer> element = list.isEmpty() ? Optional.empty() : Optional.of(list.get(index));
        return element;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

}
