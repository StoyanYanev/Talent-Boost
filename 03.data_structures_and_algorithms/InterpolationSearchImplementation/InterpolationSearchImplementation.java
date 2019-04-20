package InterpolationSearchImplementation;

public class InterpolationSearchImplementation {
    public static boolean InterpolationSearch(Integer[] arr, int start, int end, int x) {
        if (start <= end && x >= arr[start] && x <= arr[end]) {
            int position = start + (((end - start) / (arr[end] - arr[start])) * (x - arr[start]));
            if (arr[position] == x) {
                return true;
            } else if (arr[position] < x) {
                return InterpolationSearch(arr, position + 1, end, x);
            } else {
                return InterpolationSearch(arr, start, position - 1, x);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6};
        System.out.println(InterpolationSearch(arr, 0, arr.length - 1, 4));
        System.out.println(InterpolationSearch(arr, 0, arr.length - 1, 8));
    }
}
