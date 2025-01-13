package LeetCode.SlidingWindow;
/*
LeetCode problem #992 solution
Link : https://leetcode.com/problems/subarrays-with-k-different-integers/
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class KDistinctSubs {
    private static int windowSlide(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int counter = 0, i = 0, j = 0, n = arr.length;

        while (j < n) {
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);
            while (freq.size() > k) {
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) - 1);
                if (freq.get(arr[i]) == 0)
                    freq.remove(arr[i]);
                i++;
            }
            j++;
            counter += j - i + 1;
        }
        return counter;
    }

    public static int countSubs(int[] arr, int k) {
        if (arr.length == 0 || arr.length < k)
            return 0;
        if (arr.length == 1 && k == 1)
            return 1;
        return windowSlide(arr, k) - windowSlide(arr, k - 1);
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
        System.out
                .println(String.format("\nNumber of subarrays with %d distinct elements = %d\n", k, countSubs(arr, k)));
    }
}
