package GfG.DP;
/* 
GfG problem - "0 - 1 Knapsack Problem" solution
Link : https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 */

public class Knapsack {
    public static int knapsack(int W, int val[], int wt[]) {
        int n = wt.length, include, exclude;
        int[][] dp = new int[n][W + 1];

        for (int w = wt[0]; w <= W; w++)
            dp[0][w] = (wt[0] <= W) ? val[0] : 0;

        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                exclude = dp[i - 1][w];
                include = (wt[i] <= w) ? val[i] + dp[i - 1][w - wt[i]] : 0;

                dp[i][w] = Math.max(include, exclude);
            }
        }
        return dp[n - 1][W];
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
