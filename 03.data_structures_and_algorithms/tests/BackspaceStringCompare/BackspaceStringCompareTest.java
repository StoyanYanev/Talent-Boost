package BackspaceStringCompare;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackspaceStringCompareTest {

    @Test
    public void testBackspaceStringCompare() {
        BackspaceStringCompare b = new BackspaceStringCompare();

        assertEquals(true, b.backspaceCompare("y#fo##f", "y#f#o##f"));
        assertEquals(true, b.backspaceCompare("ab#c", "ad#c"));
        assertEquals(false, b.backspaceCompare("a#c", "b"));
    }

}