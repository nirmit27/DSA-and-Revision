package LeetCode.Searching;
/* 
LeetCode problem #162 solution
Link : https://leetcode.com/problems/find-peak-element/
 */

import java.util.Scanner;

public class PeakElement {
    public static int peakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        int mid = left + (right - left) / 2;

        while (left < right) {
            if (arr[mid] > arr[mid + 1])
                right = mid;
            else
                left = mid + 1;
            mid = left + (right - left) / 2;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr;
        int size, result;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            arr = new int[size];
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();
        }
        result = peakElement(arr);
        System.out.println(String.format("\nPeak element : %d", arr[result]));
    }
}
