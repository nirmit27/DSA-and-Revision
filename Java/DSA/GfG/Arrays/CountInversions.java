package GfG.Arrays;
/* 
GfG problem - "Count Inversions" solution
Link : https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 */

import java.util.Scanner;

public class CountInversions {
    static int countAndMerge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++)
            left[i] = arr[l + i];

        for (int j = 0; j < n2; j++)
            right[j] = arr[m + 1 + j];

        int res = 0, i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                res += n1 - i;
                arr[k++] = right[j++];
            }
        }

        while (i < n1)
            arr[k++] = left[i++];
        while (j < n2)
            arr[k++] = right[j++];

        return res;
    }

    static int countInversions(int[] arr, int left, int right) {
        int res = 0;

        if (left < right) {
            int mid = left + (right - left) / 2;

            res += countInversions(arr, left, mid);
            res += countInversions(arr, mid + 1, right);
            res += countAndMerge(arr, left, mid, right);
        }
        return res;
    }

    public static int inversionCount(int arr[]) {
        return countInversions(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr;
        int size, result;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            
            arr = new int[size];
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();
        }
        result = countInversions(arr, 0, arr.length - 1);
        System.out.println(String.format("\nNumber of inversions needed : %d", result));
    }
}
