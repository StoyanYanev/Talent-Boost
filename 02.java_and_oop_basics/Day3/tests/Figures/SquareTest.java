package Interfaces.Figures;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    @Test
    public void testSquare() {
        Shape s = new Square(3);
        assertEquals(9, s.getArea(), 0.01);
    }
}