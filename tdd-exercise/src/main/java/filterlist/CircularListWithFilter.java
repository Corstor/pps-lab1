package filterlist;

import java.util.Optional;

public interface CircularListWithFilter {

    boolean isEmpty();

    int size();

    void add(int element);

    Optional<Integer> next();

    Optional<Integer> previous();

}
