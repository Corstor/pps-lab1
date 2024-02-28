package filterlist;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListWithFilter {

    boolean isEmpty();

    int size();

    void add(int element);

    Optional<Integer> next();

    Optional<Integer> previous();

    Optional<Integer> filteredNext(Predicate<Integer> predicate);

    void reset();

}
