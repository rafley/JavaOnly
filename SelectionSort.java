package ASD;

import java.util.Arrays;

/**
 * Selection Sort Algorithm to sort an Integer Array
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {24, 14, 45, 82, 92, 71, 20, 22, 88};
        selectionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minI = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minI]) {
                    minI = j;
                }
            }
            int tempValue = arr[minI];
            arr[minI] = arr[i];
            arr[i] = tempValue;
        }
    }
}
