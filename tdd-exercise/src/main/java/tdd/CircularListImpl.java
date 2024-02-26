package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int index = 0;

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
        return getElement();
    }

    @Override
    public Optional<Integer> previous() {
        return getElement();
    }

    private Optional<Integer> getElement() {
        Optional<Integer> element = list.isEmpty() ? Optional.empty() : Optional.of(list.get(index));
        index = index + 1;
        return element;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("Unimplemented method 'reset'");
    }

}
