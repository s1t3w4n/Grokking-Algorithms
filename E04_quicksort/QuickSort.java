package E04_quicksort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] numbers = {-1, 10, 5, -2, 2, 3, 11, 0, 12, -123};
        quickSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int current = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[current] > arr[i]) {
                int tmp = arr[current];
                arr[current] = arr[i];
                arr[i] = arr[current + 1];
                arr[current + 1] = tmp;
                current = current + 1;
            }
        }
        quickSort(arr, start, current - 1);
        quickSort(arr, current + 1, end);
    }
}