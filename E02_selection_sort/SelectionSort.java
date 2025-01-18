package E02_selection_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] sorted = selectionSort(new int[]{5, 3, 6, 2, 10});
        System.out.println(Arrays.toString(sorted));
    }

    private static int[] selectionSort(int[] arr) {
        for (int a = 0; a < arr.length; a++) {
            int smallest = findSmallest(arr, a);
            if (smallest != a) {
                int tmp = arr[smallest];
                arr[smallest] = arr[a];
                arr[a] = tmp;
            }
        }
        return arr;
    }

    private static int findSmallest(int[] arr, int startIndex) {
        int smallIndex = startIndex;
        for (int i = smallIndex + 1; i < arr.length; i++) {
            if (arr[smallIndex] > arr[i]) {
                smallIndex = i;
            }
        }
        return smallIndex;
    }
}
