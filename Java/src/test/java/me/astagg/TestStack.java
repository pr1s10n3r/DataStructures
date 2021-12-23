package me.astagg;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestStack {
    @Test
    public void testPush() {
        final Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");

        Assertions.assertEquals(2, stack.getSize());
        Assertions.assertEquals("world", stack.getTopValue());
    }

    @Test
    public void testSinglePop() {
        final Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("this");
        stack.push("is");
        stack.push("a");
        stack.push("java");
        stack.push("stack");

        final String popValue = stack.pop();

        Assertions.assertEquals(6, stack.getSize());
        Assertions.assertEquals("stack", popValue);
        Assertions.assertEquals("java", stack.getTopValue());
    }

    @Test
    public void testMultiplePop() {
        final Stack<String> stack = new Stack<>();
        stack.push("hello");
        stack.push("world");
        stack.push("this");
        stack.push("is");
        stack.push("a");
        stack.push("java");
        stack.push("stack");

        final String firstPopValue = stack.pop();
        Assertions.assertEquals("stack", firstPopValue);
        final String secondPopValue = stack.pop();
        Assertions.assertEquals("java", secondPopValue);
        final String thirdPopValue = stack.pop();
        Assertions.assertEquals("a", thirdPopValue);

        Assertions.assertEquals(4, stack.getSize());
        Assertions.assertEquals("is", stack.getTopValue());
    }

    @Test
    public void testPopEmptyStack() {
        final Stack<String> stack = new Stack<>();
        final Exception exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, stack::pop);
        Assertions.assertEquals("stack is empty", exception.getMessage());
    }
}
