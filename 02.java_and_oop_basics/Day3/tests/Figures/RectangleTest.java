package Interfaces.Figures;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    @Test
    public void testRectangle() {
        Shape r = new Rectangle(5, 6);
        assertEquals(30, r.getArea(), 0.01);
    }
}