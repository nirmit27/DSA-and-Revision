package GfG.PrefixSum;
/* 
GfG problem - "Longest subarray with sum divisible by K" solution
Link : https://www.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class LongSubDivK {
    public static int longestSubDivK(int[] arr, int k) {
        int res = 0, sum = 0, n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum = ((sum + arr[i]) % k + k) % k;

            if (sum == 0)
                res = i + 1;
            else if (map.containsKey(sum))
                res = Math.max(res, i - map.get(sum));
            else
                map.put(sum, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the divisor : ");
            k = sc.nextInt();

            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(
                String.format("\nLongest subarray with sum divisible by %d : %d\n", k, longestSubDivK(arr, k)));
    }
}
