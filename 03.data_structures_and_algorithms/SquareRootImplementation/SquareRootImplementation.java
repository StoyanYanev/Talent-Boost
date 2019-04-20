package SquareRootImplementation;

public class SquareRootImplementation {
    public static double BinarySearch(double x) {
        double start = 0.0;
        double end = x;
        double sqrt = 0.0;
        double epsil = 0.001;

        while (start <= end) {
            double middle = (start + end) / 2;
            sqrt = middle;
            if (Math.abs(middle * middle - x) <= epsil) {
                break;
            } else if (middle * middle < x) {
                start = middle;
            } else {
                end = middle;
            }
        }
        return sqrt;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch(9));
        System.out.println(BinarySearch(5));
        System.out.println(BinarySearch(6));
        System.out.println(BinarySearch(4));
        System.out.println(BinarySearch(25));
    }
}