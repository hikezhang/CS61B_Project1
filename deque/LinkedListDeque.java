package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    private class Node {
        private T item;
        private Node prev;
        private Node next;

        private Node(T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    /* The first item, if it exits, is at sentinel.next. */
    private Node sentinel;

    private int size;

    /* Creates a new Deque with an item, namely x. */
//    public LinkedListDeque(T x) {
//        sentinel = new Node(null, null, null);
//        Node front = new Node(x, sentinel, sentinel);
//        sentinel.prev = front;
//        sentinel.next = front;
//        size = 1;
//    }

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    /* Add an item to the front of the deque. */
    public void addFirst(T item) {
        Node newNode = new Node(item, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    @Override
    public void addLast(T item) {
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

//    /* Return true if nothing in the deque. */
//    public boolean isEmpty(){
//        return size == 0;
//    }

    @Override
    /* Get the size of deque. */
    public int size() {
        return size;
    }

    @Override
    /* Just for checking the items in deque. */
    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    /* Remove the first node and return it. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node removeItem = sentinel.next;
        sentinel.next = removeItem.next;
        removeItem.next.prev = sentinel;
        size -= 1;
        return removeItem.item;
    }

    @Override
    /* Remove the last node and return it. */
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node removeNode = sentinel.prev;
        removeNode.prev.next = sentinel;
        sentinel.prev = removeNode.prev;
        size -= 1;
        return removeNode.item;
    }

    @Override
    /* Get the i-th item with iteration. */
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node p = sentinel.next;
        for (int i = 0; i < index; i += 1) {
            p = p.next;
        }
        return p.item;
    }

    /* Get the i-th item with recursion. */
    /* Can I really achieve this with a single argument int index? */
    public T getRecursive(int index) {
        Node p = sentinel.next;
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(p, index);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        node = node.next;
        index -= 1;
        return getRecursiveHelper(node, index);
    }


    private class LLDIterator implements Iterator<T> {
        private Node currNode;

        LLDIterator() {
            currNode = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return currNode != sentinel;
        }

        @Override
        public T next() {
            T returnItem = currNode.item;
            currNode = currNode.next;
            return returnItem;
        }
    }

    /* I don't know what iterator is! */
    public Iterator<T> iterator() {
        return new LLDIterator();
    }

    /* Check if o equals to this LinkedListDeque. */
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
