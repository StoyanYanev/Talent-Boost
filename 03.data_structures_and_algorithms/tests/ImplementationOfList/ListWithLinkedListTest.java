package ImplementationOfList;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListWithLinkedListTest {
    @Test(expected = IllegalArgumentException.class)
    public void testListWithLinkedList() {
        List l = new ListWithLinkedList();

        assertEquals(0, l.size().intValue());
        assertEquals(null, l.get(2));

        for (int i = 0; i < 5; i++) {
            l.add(i);
        }
        ((ListWithLinkedList) l).print();
        assertEquals(5, l.size().intValue());

        l.reverse();
        ((ListWithLinkedList) l).print();

        for (int i = 5; i < 10; i++) {
            l.put(i, i);
        }

        assertEquals(10, l.size().intValue());

        l.put(8, -1);
    }
}