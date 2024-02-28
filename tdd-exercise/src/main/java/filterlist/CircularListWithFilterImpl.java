package filterlist;

import java.util.LinkedList;
import java.util.List;

public class CircularListWithFilterImpl implements CircularListWithFilter {

    private List<Integer> list = new LinkedList<>();

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

}
