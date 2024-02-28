package filterlist;

import java.util.Optional;
import java.util.function.Predicate;

import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularListWithFilterImpl implements CircularListWithFilter {

    private CircularList list = new CircularListImpl();

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public Optional<Integer> next() {
        return list.next();
    }

    @Override
    public Optional<Integer> previous() {
        return list.previous();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        for (int i = 0; i < size(); i++) {
            Optional<Integer> next = next();
            if (predicate.test(next.get())) {
                return next;
            }
        }

        return Optional.empty();
    }

}
