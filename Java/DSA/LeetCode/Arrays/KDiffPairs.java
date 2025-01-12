package LeetCode.Arrays;
/*
LeetCode problem #532 solution
Link : https://leetcode.com/problems/k-diff-pairs-in-an-array/
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class KDiffPairs {
    public static int countPairs(int[] arr, int k) {
        if (arr.length < 2)
            return 0;
        if (arr.length == 2)
            return (arr[0] - arr[1] == k || arr[1] - arr[0] == k) ? 1 : 0;

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr)
            map.put(n, map.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if ((map.containsKey(entry.getKey() + k) && k != 0) || (k == 0 && entry.getValue() > 1))
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the value of k : ");
            k = sc.nextInt();
            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nNumber of %d-differnce pairs = %d", k, countPairs(arr, k)));
    }
}
