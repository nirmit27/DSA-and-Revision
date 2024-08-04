/*
Recursive Bubble Sort
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Bubble {
    static void display(ArrayList<Integer> arr) {
        if (arr.size() <= 1)
            return;

        System.out.print("\nArray status : ");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    static void bubbleSort(ArrayList<Integer> arr, int i, int j) {
        if (arr.size() <= 1)
            return;
        if (i == 0)
            return;

        if (j < i) {
            if (arr.get(j) > arr.get(j + 1)) {
                int temp = arr.get(j);
                arr.set(j, arr.get(j + 1));
                arr.set(j + 1, temp);
            }
            bubbleSort(arr, i, j + 1);
        } else {
            bubbleSort(arr, i - 1, 0);
        }
    }

    public static void main(String[] args) {
        int n;
        ArrayList<Integer> arr = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size : ");
            n = sc.nextInt();
            System.out.print("\nEnter the array : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        display(arr);
        bubbleSort(arr, arr.size() - 1, 0);
        display(arr);
    }
}
