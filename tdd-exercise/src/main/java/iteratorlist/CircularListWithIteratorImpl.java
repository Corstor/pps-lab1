package iteratorlist;

import java.util.LinkedList;
import java.util.List;

public class CircularListWithIteratorImpl implements CircularListWithIterator {

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

}
