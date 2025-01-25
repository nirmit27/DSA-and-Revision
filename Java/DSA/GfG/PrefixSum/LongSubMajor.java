package GfG.PrefixSum;
/* 
GfG problem - "Longest Subarray with Majority Greater than K" solution
Link : https://www.geeksforgeeks.org/problems/longest-subarray-with-majority-greater-than-k/1
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class LongSubMajor {
    public static int longestSubMajor(int[] arr, int k) {
        int res = 0, sum = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        // TODO

        return res;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the target sum : ");
            k = sc.nextInt();

            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nLongest subarray length with sum %d : %d\n", k, longestSubMajor(arr, k)));
    }
}
