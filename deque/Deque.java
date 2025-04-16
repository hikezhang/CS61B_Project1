package deque;


public interface Deque<T> {
    void addFirst(T item);

    void addLast(T item);

    default boolean isEmpty() {
        return size() == 0;
    }

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int index);

    default boolean contains(T x) {
        for (int i = 0; i < size(); i += 1) {
            if (get(i).equals(x)) {
                return true;
            }
        }
        return false;
    }
}
