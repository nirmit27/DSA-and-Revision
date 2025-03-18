package GfG.DP;
/* 
GfG problem - "Longest Palindromic Subsequence" solution
Link : https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
 */

public class LPS {
    private static int solution(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dp[i + 1][j + 1] = (s1.charAt(i) == s2.charAt(j)) ? 1 + dp[i][j] : Math.max(dp[i + 1][j], dp[i][j + 1]);
        }

        return dp[m][n];
    }

    public static int longestPalinSubseq(String s) {
        return solution(s, new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
