package ImplementationOfList;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class ListWithArrayTest {
    @Test(expected = Exception.class)
    public void testListWithArray() {
        List listArray = new ListWithArray();

        assertEquals(0, listArray.size().intValue());
        listArray.get(0);

        for (int i = 0; i <= 5; i++) {
            listArray.add(i);
        }
        assertEquals(6, listArray.size().intValue());

        listArray.put(1, 20);
        assertEquals(7, listArray.size().intValue());

        listArray.put(0, 10);
        assertEquals(8, listArray.size().intValue());

        listArray.put(7, 1);
        assertEquals(9, listArray.size().intValue());

        for (int i = 0; i < 90; i++) {
            listArray.add(i);
        }
        assertEquals(99, listArray.size().intValue());

        listArray.put(99, -6);
        assertEquals(100, listArray.size().intValue());
    }
}