package StackAndQueueWithLinkedList;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTestWithException {
    @Test(expected = EmptyStackException.class)
    public void testStackTestException() {
        Behavior s = new Stack();

        s.push(5);
        assertEquals(5, s.peek().intValue());

        s.pop();
        assertEquals(null, s.peek());
        s.pop();
    }
}