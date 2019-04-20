package TwoDimensionalMatrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void testMatrix() {
        Matrix matrix = new Matrix(5, 6);

        assertEquals(0, matrix.getElement(3, 2).intValue());
        assertEquals(null, matrix.getElement(5, 6));
        assertEquals(false, matrix.isSquare());

        Matrix squareMatrix = new Matrix(5, 5);
        assertEquals(true, squareMatrix.isSquare());
    }
}