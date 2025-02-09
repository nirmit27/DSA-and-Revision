/* Revisiting the Sorting algorithms */

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

class Sorting {
    static void display(ArrayList<Integer> arr) {
        if (arr.size() == 0)
            return;
        System.out.print("\nArray status : ");

        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
        System.out.println();
    }

    static void swap(ArrayList<Integer> arr, int i, int j) {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }

    static int getMaxIndex(ArrayList<Integer> arr, int start, int end) {
        int maxIndex = 0;
        for (int i = start; i <= end; i++) {
            if (arr.get(i) > arr.get(maxIndex))
                maxIndex = i;
        }
        return maxIndex;
    }

    static void countingSort(ArrayList<Integer> arr) {
        int max = Collections.max(arr);
        int[] temp = new int[arr.size()];

        // Step 1 : Array for storing the frequency of each element
        int[] count = new int[max + 1];
        Arrays.fill(count, 0);

        // Step 2 : Store the count of each element
        for (int n : arr)
            count[n]++;

        // Step 3 : Update the count array with prefix sum
        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        // Step 4 : Create a temporary array to store the sorted elements
        for (int i = arr.size() - 1; i >= 0; i--) {
            temp[count[arr.get(i)] - 1] = arr.get(i);
            count[arr.get(i)]--;
        }

        // Step 5 : Copy the sorted elements back to the original array
        for (int i = 0; i < arr.size(); i++)
            arr.set(i, temp[i]);
    }

    static void insertionSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1)
            return;

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr.get(j) < arr.get(j - 1))
                    swap(arr, j, j - 1); // Sort elements on the LHS sub-array
                else
                    break;
            }
        }
    }

    static void selectionSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1)
            return;

        for (int i = 0; i < arr.size(); i++) {
            int last = arr.size() - i - 1;
            int maxIndex = getMaxIndex(arr, 0, last);
            swap(arr, maxIndex, last); // Swap `i`th last element with `i`th maximum element
        }
    }

    static void bubbleSortRecursive(ArrayList<Integer> arr, int i, int j) {
        if (arr.size() <= 1)
            return;
        if (i == 0)
            return;

        if (j < i) {
            if (arr.get(j) > arr.get(j + 1)) {
                swap(arr, j, j + 1);
            }
            bubbleSortRecursive(arr, i, j + 1);
        } else {
            bubbleSortRecursive(arr, i - 1, 0);
        }
    }

    static void bubbleSort(ArrayList<Integer> arr) {
        if (arr.size() <= 1)
            return;
        boolean swapped = false;

        for (int i = 0; i < arr.size(); i++) {
            for (int j = 1; j < arr.size() - i; j++) {
                if (arr.get(j) < arr.get(j - 1))
                    swap(arr, j, j - 1); // Swap elements in PAIRS
                swapped = true;
            }
            if (!swapped) // For an ALREADY sorted array
                break;
        }
    }

    public static void main(String[] args) {
        int size;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++) {
                int x;
                x = sc.nextInt();
                arr.add(x);
            }
            display(arr);

            /*
             * bubbleSort(arr);
             * bubbleSortRecursive(arr, arr.size() - 1, 0);
             * selectionSort(arr);
             * insertionSort(arr);
             */

            countingSort(arr);
            display(arr);
        }
    }
}
