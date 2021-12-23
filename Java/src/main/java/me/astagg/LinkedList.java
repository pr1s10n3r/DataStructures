package me.astagg;

public class LinkedList<T> {
    private Node<T> head;
    private long size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T value) {
        final Node<T> next = new Node<>(null, value);

        if (head == null) {
            head = next;
        } else {
            Node<T> prev = head;
            Node<T> index = head.getNext();

            while (index != null) {
                prev = index;
                index = index.getNext();
            }

            prev.setNext(next);
        }

        this.size++;
    }

    public T remove(long i) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= size)
            throw new ArrayIndexOutOfBoundsException("index is greater than list size or lower than zero");

        --size;

//        0 list.add(69);
//        1 list.add(420);
//        2 list.add(30);

        Node<T> index = head;
        Node<T> prev = index;

        if (i == 0) {
            head = head.getNext();
            return index.getValue();
        }

        for (int j = 0; j < i; j++) {
            prev = index;
            index = index.getNext();
        }

        prev.setNext(index.getNext());
        return index.getValue();
    }

    public T at(long i) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= size)
            throw new ArrayIndexOutOfBoundsException("index is greater than list size or lower than zero");

        if (i == 0)
            return head.getValue();

        Node<T> value = head.getNext();
        for (int j = 0; j < (i - 1); j++)
            value = value.getNext();

        return value.getValue();
    }

    public LinkedList<T> reverse() {
        final LinkedList<T> reversed = new LinkedList<>();
        if (size == 0) {
            return reversed;
        }
        if (size == 1) {
            return this;
        }

        final Stack<T> elements = new Stack<>();
        Node<T> index = head;

        while (index != null) {
            elements.push(index.getValue());
            index = index.getNext();
        }

        while (elements.getSize() > 0)
            reversed.add(elements.pop());

        return reversed;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
