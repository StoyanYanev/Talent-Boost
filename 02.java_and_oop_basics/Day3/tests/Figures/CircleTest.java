package Interfaces.Figures;

import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {
    @Test
    public void testCircle() {
        Shape c = new Circle(5);
        assertEquals(78.53, c.getArea(),0.01);
    }
}