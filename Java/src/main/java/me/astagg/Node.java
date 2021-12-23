package me.astagg;

public class Node<T> {
    private Node<T> next;
    private T value;

    public Node(final Node<T> next, final T value) {
        this.next = next;
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
