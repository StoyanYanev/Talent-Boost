package StackAndQueueWithLinkedList;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class QueueTestWithException {
    @Test(expected = EmptyStackException.class)
    public void testQueueTestException() {
        Behavior q = new Queue();

        q.push(5);
        assertEquals(5, q.peek().intValue());

        q.pop();
        assertEquals(null, q.peek());
        q.pop();
    }
}