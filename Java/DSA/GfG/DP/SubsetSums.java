package GfG.DP;
/* 
    --- GfG Problems ---
    #1 : "Subset Sum Problem" solution
    Link : https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1

    #2 : "Partition Equal Subset Sum" solution
    Link : https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1
 */

import java.util.Arrays;

public class SubsetSums {
    /* Problem #2 */
    private static Boolean[][] memo;

    private static boolean solve2(int sum, int i, int[] arr) {
        if (i == arr.length)
            return sum == 0;

        if (memo[i][sum] != null)
            return memo[i][sum];

        memo[i][sum] = false;

        if (arr[i] <= sum)
            memo[i][sum] |= solve2(sum - arr[i], i + 1, arr);
        memo[i][sum] |= solve2(sum, i + 1, arr);

        return memo[i][sum];
    }

    public static boolean equalPartition(int arr[]) {
        int sum = Arrays.stream(arr).sum(), n = arr.length;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        memo = new Boolean[n][target + 1];

        return solve2(target, 0, arr);
    }

    /* Problem #1 */
    private static Boolean solve1(int[][] dp, int[] arr, int n, int sum) {
        if (sum == 0)
            return true;

        if (n <= 0)
            return false;

        if (dp[n][sum] != -1)
            return dp[n][sum] == 1;

        if (arr[n - 1] > sum)
            dp[n][sum] = solve1(dp, arr, n - 1, sum) ? 1 : 0;
        else
            dp[n][sum] = (solve1(dp, arr, n - 1, sum - arr[n - 1]) || solve1(dp, arr, n - 1, sum)) ? 1 : 0;

        return dp[n][sum] == 1;
    }

    public static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);
        return solve1(dp, arr, n, sum);
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
