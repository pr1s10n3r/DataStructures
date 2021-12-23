package me.astagg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestNode {
    @Test
    public void testNoChildren() {
        Node<Integer> node = new Node<>(null, 1);
        Assertions.assertEquals(0, node.children());
    }

    @Test
    public void testChildren() {
        Node<Integer> node = new Node<>(
                new Node<>(
                        new Node<>(
                                new Node<>(
                                        null, 4), 3), 2), 1);
        Assertions.assertEquals(3, node.children());
    }
}
