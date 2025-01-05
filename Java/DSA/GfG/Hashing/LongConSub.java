package GfG.Hashing;
/* 
GfG problem - "Longest Consecutive Subsequence" solution
Link : https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongConSub {
    public static int hashingApproch(int[] arr) {
        int ans = 0, temp = 0;
        Set<Integer> set = new HashSet<>();

        for (int n : arr)
            set.add(n);

        for (int n : arr) {
            if (!set.contains(n - 1)) {
                temp = 0;
                while (set.contains(n++))
                    temp++;
                ans = Math.max(ans, temp);
            }
        }
        return ans;
    }

    public static int sortingApproch(int[] arr) {
        Arrays.sort(arr);
        int ans = 1, ctr = 1, temp = Integer.MIN_VALUE;

        for (int n : arr) {
            if (n == temp + 1)
                ctr++;
            else if (n != temp)
                ctr = 1;
            temp = n;
            ans = Math.max(ans, ctr);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr;
        int n, res1, res2;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the array size : ");
            n = sc.nextInt();
            arr = new int[n];

            System.out.print("Enter the array elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res1 = sortingApproch(arr);
        res2 = hashingApproch(arr);
        System.out.println(String.format("\nLongest Consecutive Subsequence : %d", res1 == res2 ? res1 : 0));
    }
}
