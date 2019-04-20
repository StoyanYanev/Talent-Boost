package TwoDimensionalMatrix;

public class Matrix implements MatrixBehavior {

    private int n;
    private int m;
    private int matrix[][];

    Matrix(int n, int m) {
        try {
            this.n = n;
            this.m = m;
            this.matrix = new int[this.n][this.m];
        } catch (NegativeArraySizeException e) {
            System.out.println("The size can not be a negative!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean isSquare() {
        return this.n == this.m;
    }

    @Override
    public Integer getElement(int from, int to) {
        if (this.n > from && this.m > to) {
            return this.matrix[from][to];
        }
        return null;
    }
}