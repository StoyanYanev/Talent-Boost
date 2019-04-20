package ImplementationOfQueue;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class QueueTestWithException {
    @Test(expected = EmptyStackException.class)
    public void testQueueWithException() {
        BehaviorOfQueue q = new Queue();
        q.dequeue();
    }
}