package QuickSortImplementation;

public class QuickSortImplement {
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int s = start - 1;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                s++;
                int temp = arr[i];
                arr[i] = arr[s];
                arr[s] = temp;
            }
        }
        int temp = arr[s + 1];
        arr[s + 1] = arr[end];
        arr[end] = temp;

        return s + 1;
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7}; //{10, 7, 8, 9, 1, 5}; {10, 80, 30, 90, 40, 50, 70};
        QuickSortImplement qu = new QuickSortImplement();
        qu.quickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}