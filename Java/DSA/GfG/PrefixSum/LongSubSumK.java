package GfG.PrefixSum;
/* 
GfG problem - "Longest Subarray with Sum K" solution
Link : https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class LongSubSumK {
    public static int longestSubarray(int[] arr, int k) {
        int ans = 0, prefix = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            prefix += arr[i];

            // Case 1 - Leftmost subarray
            if (prefix == k)
                ans = i + 1;

            // Case 2 - Intermediate subarray
            if (map.containsKey(prefix - k))
                ans = Math.max(ans, i - map.get(prefix - k));

            // Prefix summation
            if (!map.containsKey(prefix))
                map.put(prefix, i);
        }
        return ans;
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
        System.out.println(String.format("\nLongest subarray length with sum %d : %d\n", k, longestSubarray(arr, k)));
    }
}
