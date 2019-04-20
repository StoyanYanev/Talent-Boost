package ImplementationOfQueue;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void tesQueue() {
        BehaviorOfQueue q = new Queue();

        assertEquals(0, q.size());
        assertEquals(null, q.peek());

        for (int i = 0; i <= 99; i++) {
            q.enqueue(i);
        }
        assertEquals(0, q.peek().intValue());

        for (int i = 99, j = 0; i >= 0; i--, j++) {
            assertEquals(j, q.dequeue());
        }
        assertEquals(0, q.size());

        for (int i = 0; i <= 100; i++) {
            q.enqueue(i);
        }
        assertEquals(0, q.peek().intValue());
        assertEquals(101, q.size());
    }
}