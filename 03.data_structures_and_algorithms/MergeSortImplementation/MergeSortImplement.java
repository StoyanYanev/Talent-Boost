package MergeSortImplementation;

public class MergeSortImplement {
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    public void merge(int[] arr, int left, int middle, int right) {
        int sizeOfLeftArray = middle - left + 1;
        int sizeOfRightArray = right - middle;
        int[] leftArray = new int[sizeOfLeftArray];
        int[] rightArray = new int[sizeOfRightArray];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < rightArray.length; ++j) {
            rightArray[j] = arr[middle + 1 + j];
        }

        int indexOfLeft = 0;
        int indexOfRight = 0;
        int k = left;
        while (indexOfLeft < leftArray.length && indexOfRight < rightArray.length) {
            if (leftArray[indexOfLeft] <= rightArray[indexOfRight]) {
                arr[k] = leftArray[indexOfLeft];
                indexOfLeft++;
            } else {
                arr[k] = rightArray[indexOfRight];
                indexOfRight++;
            }
            k++;
        }

        while (indexOfLeft < leftArray.length) {
            arr[k] = leftArray[indexOfLeft];
            indexOfLeft++;
            k++;
        }

        while (indexOfRight < rightArray.length) {
            arr[k] = rightArray[indexOfRight];
            indexOfRight++;
            k++;
        }
    }

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        MergeSortImplement ms = new MergeSortImplement();
        ms.mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}