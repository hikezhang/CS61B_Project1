package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private T returnVal;
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.comparator = c;
    }

    public T max() {
        if (this.isEmpty()) {
            return null;
        }
        returnVal = get(0);
        for (int i = 0; i < size(); i += 1) {
            if (comparator.compare(get(i), returnVal) > 0) {
                returnVal = get(i);
            }
        }
        return returnVal;
    }

    public T max(Comparator<T> c) {
        if (this.isEmpty()) {
            return null;
        }
        returnVal = get(0);
        for (int i = 0; i < size(); i += 1) {
            if (c.compare(get(i), returnVal) > 0) {
                returnVal = get(i);
            }
        }
        return returnVal;
    }
}
