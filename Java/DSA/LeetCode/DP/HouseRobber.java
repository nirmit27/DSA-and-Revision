package LeetCode.DP;
/* 
LeetCode problem #198 solution
Link : https://leetcode.com/problems/house-robber/
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class HouseRobber {
    public static int amount(ArrayList<Integer> arr) {
        if (arr.size() == 1)
            return arr.get(0);

        int n = arr.size();
        int[] dp = new int[n];
        Arrays.fill(dp, 0);

        dp[0] = arr.get(0);
        dp[1] = Math.max(arr.get(0), arr.get(1));

        for (int i = 2; i < n; i++)
            dp[i] = Math.max(dp[i - 1], arr.get(i) + dp[i - 2]);

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the no. of houses : ");
            n = sc.nextInt();

            System.out.print("\nEnter the money stashed in the houses : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = amount(arr);
        System.out.println(String.format("\nAmount robbed from alternate houses : %d", result));
    }
}
