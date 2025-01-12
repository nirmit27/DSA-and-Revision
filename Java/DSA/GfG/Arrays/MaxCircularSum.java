package GfG.Arrays;
/* 
GfG problem - "Max Circular Subarray Sum" solution
Link : https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
 */

import java.util.Scanner;

public class MaxCircularSum {
    public static int maxCircularSum(int[] arr) {
        int totalSum = 0;
        int currentMin = 0, currentMax = 0;
        int minSum = arr[0], maxSum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];

            currentMin = Math.min(currentMin + arr[i], arr[i]);
            minSum = Math.min(minSum, currentMin);

            currentMax = Math.max(currentMax + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        int circularSum = totalSum - minSum;
        if (totalSum == minSum)
            return maxSum;

        return Math.max(circularSum, maxSum);
    }

    public static void main(String[] args) {
        int size;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            arr = new int[size];

            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nMaximum circular subarray sum : %d", maxCircularSum(arr)));
    }

}
