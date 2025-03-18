package GfG.DP;
/* 
    --- GfG Problems ---
    #1 : "Coin Change (Count Ways)" solution
    Link : https://www.geeksforgeeks.org/problems/coin-change2448/1

    #2 : "Coin Change (Minimum Coins)" solution
    Link : https://www.geeksforgeeks.org/problems/number-of-coins1824/1
 */

public class CoinChanges {
    /* Problem #2 */
    public static int minCoins(int coins[], int sum) {
        int n = coins.length, take, noTake;
        int[][] dp = new int[coins.length][sum + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= sum; j++) {
                take = Integer.MAX_VALUE;
                noTake = Integer.MAX_VALUE;
                dp[i][j] = Integer.MAX_VALUE;

                if (j >= coins[i]) {
                    take = dp[i][j - coins[i]];

                    if (take != Integer.MAX_VALUE)
                        take++;
                }

                if ((i + 1) < n)
                    noTake = dp[i + 1][j];

                dp[i][j] = Math.min(take, noTake);
            }
        }
        return (dp[0][sum] != Integer.MAX_VALUE) ? dp[0][sum] : -1;
    }

    /* Problem #1 */
    public static int count(int coins[], int sum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) { // number of coins
            for (int j = 0; j <= sum; j++) { // current sum
                dp[i][j] += dp[i - 1][j]; // without the current coin
                dp[i][j] += (j >= coins[i - 1]) ? dp[i][j - coins[i - 1]] : 0; // with the current coin
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
