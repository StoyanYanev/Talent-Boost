package StackAndQueueWithLinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void testStack() {
        Behavior s = new Stack();

        assertEquals(0, s.size());
        assertEquals(null, s.peek());

        for (int i = 0; i <= 9; i++) {
            s.push(i);
        }
        assertEquals(10,s.size());

        for (int i = 9; i >= 0; i--) {
            assertEquals(i,s.pop());
        }
        assertEquals(0, s.size());
    }
}