package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int capacity;
    private int size;
    private int front;
    private int back;

    /* Starting size is 8. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        capacity = 8;
        int x = items.length;
        System.out.println(x);
        size = 0;
        front = back = 0;
    }

    /* Resize */
    private void resize(int newCapacity) {
        T[] a = (T[]) new Object[newCapacity];
        /* Resize up, front == back */
        if (newCapacity > capacity) {
            /* Copy front to end*/
            System.arraycopy(items, front, a, 0, size - front);
            /* Copy 0 to back(front) - 1 */
            System.arraycopy(items, 0, a, size - front, back);
        } else {
            /* Resize down, front != back*/
            if (front < back) {
                System.arraycopy(items, front, a, 0, size);
            } else {
                System.arraycopy(items, front, a, 0, capacity - front);
                System.arraycopy(items, 0, a, capacity - front, back);
            }
        }
        /* Let garbage collector take former array away. */
        items = a;
        capacity = newCapacity;
        back = size;
        front = 0;
    }

    /* General idea: items[front] holds value, items[back] doesn't. */
    /* back == front means empty or full. */
    @Override
    public void addFirst(T x) {
        if (front < back) {
            /* front > 0, add to items[front - 1]. */
            /* Add [ HERE front *** back ***] */
            if ((front - 1) >= 0) {
                items[front - 1] = x;
                front -= 1;
                size += 1;
            } else {
                /* front == 0, add to the last index. */
                /* Add [front *** back *** HERE] */
                items[capacity - 1] = x;
                front = capacity - 1;
                size += 1;
            }
        } else if (front > back) {
            /* Add [ *** back HERE front *** ]*/
            items[front - 1] = x;
            front -= 1;
            size += 1;
        } else {
            /* front == back, either empty or full. */
            if (size == 0) {
                items[front] = x;
                if (back < 7) {
                    back += 1;
                } else {
                    back = 0;
                }
                size += 1;
            } else {
                /* Resizing needed. */
                /* should return array like this */
                /* [full *** | empty] */
                resize(size * 2);
                items[capacity - 1] = x;
                front = capacity - 1;
                size += 1;
            }
        }

    }

//    /* Return true when Deque is empty. */
//    public boolean isEmpty(){
//        return(size == 0);
//    }

    /* Return size of the Deque. */
    @Override
    public int size() {
        return size;
    }

//    /* Return the capacity of current items length. */
//    public int capacity(){
//        return capacity;
//    }

    @Override
    /* Add to the back of the deque. */
    public void addLast(T x) {
        /* Resizing needed. */
        /* Resizing returns this */
        /* [full *** | empty] */
        if (size == capacity) {
            resize(size * 2);
            items[back] = x;
            back += 1;
            size += 1;

        } else {
            /* Add [front *** back HERE] */
            /* Or [*** back HERE front***]*/
            /* Add index 1 to capacity - 1. */
            if ((back + 1) < capacity) {
                items[back] = x;
                back += 1;
                size += 1;
            } else {
                /* Add [HERE(index 0) *** front ***back] */
                items[back] = x;
                back = 0;
                size += 1;
            }
        }
    }

    @Override
    /* Print from front to back. */
    public void printDeque() {
        if (size == 0) {
            return;
        }
        if (front < back) {
            for (int i = front; i < back; i += 1) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = front; i < capacity; i += 1) {
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < back; i += 1) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    /* Remove the item on the front(index: front). */
    public T removeFirst() {
        /* Empty ArrayDeque */
        if (size == 0) {
            return null;
        }
        /* [front *** ] */
        if (front < (capacity - 1)) {
            front += 1;
            size -= 1;
            T removedItem = items[front - 1];
            /* Resizing needed. */
            if (size < 0.25 * capacity && capacity != 8) {
                resize(capacity / 2);
            }
            return removedItem;
        } else {
            /* [ *** front(index:capacity - 1)] */
            front = 0;
            size -= 1;
            T removedItem = items[capacity - 1];
            /* Resizing needed. */
            if (size < 0.25 * capacity && capacity != 8) {
                resize(capacity / 2);
            }
            return removedItem;
        }
    }

    @Override
    /* Remove the item on the back(index: back - 1). */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        /* [ *** back] */
        if (back > 0) {
            /* Initially, items[back] is empty. */
            back -= 1;
            size -= 1;
            T removedItem = items[back];
            if (size < 0.25 * capacity && capacity != 8) {
                resize(capacity / 2);
            }
            return removedItem;
        } else {
            /* [back *** ] */
            back = capacity - 1;
            size -= 1;
            T removedItem = items[back];
            if (size < 0.25 * capacity && capacity != 8) {
                resize(capacity / 2);
            }
            return removedItem;
        }
    }

    @Override
    /* Get the i-th item. */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        if (front < back) {
            return items[front + index];
        } else {
            if (front + index < capacity) {
                return items[front + index];
            } else {
                return items[front + index - capacity];
            }
        }
    }

    private class ADIterator implements Iterator<T> {
        private int wizPos;

        ADIterator() {
            wizPos = 0;
        }

        @Override
        public boolean hasNext() {
            return wizPos < size;
        }

        @Override
        public T next() {
            T returnItem = items[(front + wizPos) % capacity];
            wizPos += 1;
            return returnItem;
        }
    }

    /* Iterator */
    public Iterator<T> iterator() {
        return new ADIterator();
    }

    /* Check if o equals to this Arraydeque. */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Deque<?>)) {
            return false;
        }
        Deque<T> otherDeque = (Deque<T>) o;
        if (this.size != otherDeque.size()) {
            return false;
        }
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = ((Iterable<T>) otherDeque).iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            T thisItem = thisIterator.next();
            T otherItem = otherIterator.next();
            if (!thisItem.equals(otherItem)) {
                return false;
            }
        }
        return true;
    }

}
