package StackAndQueueWithLinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    @Test
    public void testQueue() {
        Behavior q = new Queue();

        assertEquals(0, q.size());
        assertEquals(null, q.peek());

        for (int i = 0; i < 10; i++) {
            q.push(i);
        }
        assertEquals(10, q.size());
        assertEquals(0, q.peek().intValue());

        for (int i = 9, j = 0; i >= 0; i--, j++) {
            assertEquals(j, q.pop());
        }
    }
}