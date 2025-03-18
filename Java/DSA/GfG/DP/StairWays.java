package GfG.DP;
/* 
    --- GfG Problems ---
    #1 : "Ways to Reach the n'th Stair" solution
    Link : https://www.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1

    #2 : "Min Cost Climbing Stairs" solution
    Link : https://www.geeksforgeeks.org/problems/min-cost-climbing-stairs/1
 */

public class StairWays {
    /* Problem #2 */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];

        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++)
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    /* Problem #1 */
    public static int countWays(int n) {
        int prev = 1, curr = 1, total = 0;

        for (int i = 0; i < n; i++) {
            total = prev + curr;
            prev = curr;
            curr = total;
        }
        return prev;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
