package me.astagg;

public class Stack<T> {
    private Node<T> top;
    private long size;

    public void push(T value) {
        if (top == null) {
            top = new Node<>(null, value);
        } else {
            Node<T> next = top;
            top = new Node<>(next, value);
        }
        ++size;
    }

    public T pop() throws ArrayIndexOutOfBoundsException {
        if (size < 1)
            throw new ArrayIndexOutOfBoundsException("stack is empty");

        final T value = top.getValue();
        top = top.getNext();
        --size;

        return value;
    }

    public T getTopValue() {
        return top.getValue();
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
