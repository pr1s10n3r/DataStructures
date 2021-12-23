package me.astagg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLinkedList {
    @Test
    public void testAddEmptyList() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        Assertions.assertEquals(1, list.getSize());
    }

    @Test
    public void testAddTwoElements() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);
        Assertions.assertEquals(2, list.getSize());
    }

    @Test
    public void testAtEmptyList() {
        final LinkedList<Integer> list = new LinkedList<>();
        final Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.at(0));

        Assertions.assertEquals("index is greater than list size or lower than zero", exception.getMessage());
    }

    @Test
    public void testAtNegativeIndex() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);

        final Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.at(-1));

        Assertions.assertEquals("index is greater than list size or lower than zero", exception.getMessage());
    }

    @Test
    public void testAtGreaterIndex() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);

        final Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.at(420));

        Assertions.assertEquals("index is greater than list size or lower than zero", exception.getMessage());
    }

    @Test
    public void testAt() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        Assertions.assertEquals(69, list.at(0));
    }

    @Test
    public void testAtWithMoreThanOneItem() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);
        list.add(30);
        list.add(12);
        list.add(99);

        Assertions.assertEquals(69, list.at(0));
        Assertions.assertEquals(30, list.at(2));
    }

    @Test
    public void testRemoveEmptyList() {
        final LinkedList<Integer> list = new LinkedList<>();

        final Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(420));

        Assertions.assertEquals("index is greater than list size or lower than zero", exception.getMessage());
    }

    @Test
    public void testRemoveSingleElement() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);

        list.remove(1);
        Assertions.assertEquals(list.getSize(), 1);
        Assertions.assertEquals(list.at(0), 69);
    }

    @Test
    public void testRemoveFirstElement() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);
        list.add(30);

        final Integer removed = list.remove(0);
        Assertions.assertEquals(69, removed);

        Assertions.assertEquals(list.getSize(), 2);
        Assertions.assertEquals(420, list.at(0));
        Assertions.assertEquals(30, list.at(1));
    }

    @Test
    public void testRemoveMiddleElement() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);
        list.add(30);

        final Integer removed = list.remove(1);
        Assertions.assertEquals(420, removed);

        Assertions.assertEquals(list.getSize(), 2);
        Assertions.assertEquals(69, list.at(0));
        Assertions.assertEquals(30, list.at(1));
    }

    @Test
    public void testRemoveLastElement() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);
        list.add(30);

        final Integer removed = list.remove(2);
        Assertions.assertEquals(30, removed);

        Assertions.assertEquals(list.getSize(), 2);
        Assertions.assertEquals(69, list.at(0));
        Assertions.assertEquals(420, list.at(1));
    }

    @Test
    public void testReverseEmptyList() {
        final LinkedList<Integer> list = new LinkedList<>();
        final LinkedList<Integer> reversed = list.reverse();
        Assertions.assertEquals(list.getSize(), reversed.getSize());
        Assertions.assertNotEquals(list, reversed); // Check that memory address changed
    }

    @Test
    public void testReverseOneElementList() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);

        final LinkedList<Integer> reversed = list.reverse();

        Assertions.assertEquals(list.getSize(), reversed.getSize());
        Assertions.assertEquals(list.at(0), reversed.at(0));
    }

    @Test
    public void testReverse() {
        final LinkedList<Integer> list = new LinkedList<>();
        list.add(69);
        list.add(420);
        list.add(30);
        list.add(12);
        list.add(99);

        final LinkedList<Integer> reversed = list.reverse();
        Assertions.assertEquals(99, reversed.at(0));
        Assertions.assertEquals(12, reversed.at(1));
        Assertions.assertEquals(30, reversed.at(2));
        Assertions.assertEquals(420, reversed.at(3));
        Assertions.assertEquals(69, reversed.at(4));
    }
}
