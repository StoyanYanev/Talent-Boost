package ImplementationOfStack;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackTestWithException {
    @Test(expected = EmptyStackException.class)
    public void testStackWithException() {
        BehaviorOfStack s = new Stack();
        s.pop();
    }
}