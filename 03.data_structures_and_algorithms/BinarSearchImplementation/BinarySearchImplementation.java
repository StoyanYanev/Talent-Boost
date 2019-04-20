package BinarSearchImplementation;

public class BinarySearchImplementation {
    public static boolean BinarySearch(Integer[] arr, int start, int end, int x) {
        if (start < end) {
            int middle = start + (end - start) / 2;
            if (arr[middle] == x) {
                return true;
            } else if (arr[middle] < x) {
                return BinarySearch(arr, middle + 1, end, x);
            } else {
                return BinarySearch(arr, start, middle - 1, x);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};
        System.out.println(BinarySearch(arr, 0, arr.length, 4));
        System.out.println(BinarySearch(arr, 0, arr.length, 8));
    }
}