package ImplementationOfStack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    @Test
    public void testStack() {
        BehaviorOfStack s = new Stack();

        assertEquals(0, s.size());
        assertEquals(null, s.peek());

       for (int i = 0; i <= 99; i++) {
            s.push(i);
            assertEquals(s.size(), i + 1);
        }
        assertEquals(100,s.size());

        for (int i = 99; i >=0 ; i--) {
            assertEquals(i,s.pop());
            assertEquals(i,s.size());
        }
        assertEquals(0,s.size());


        for (int i = 0; i <= 100; i++) {
            s.push(i);
        }
        assertEquals(101,s.size());
    }
}