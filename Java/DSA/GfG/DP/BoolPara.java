package GfG.DP;
/* 
GfG problem - "Boolean Parenthesization" solution
Link : https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
 */

import java.util.Arrays;
// import java.util.Scanner;

public class BoolPara {
    private static boolean eval(int x, int y, char op) {
        switch (op) {
            case '&':
                return (x & y) == 1;
            case '|':
                return (x | y) == 1;
            default:
                return (x ^ y) == 1;
        }
    }

    private static int solve(int i, int j, int req, String s, int[][][] dp) {
        if (i == j)
            return (req == (s.charAt(i) == 'T' ? 1 : 0)) ? 1 : 0;

        if (dp[i][j][req] != -1)
            return dp[i][j][req];

        int ans = 0, lt, lf, rt, rf;

        for (int k = i + 1; k < j; k++) {
            lt = solve(i, k - 1, 1, s, dp);
            lf = solve(i, k - 1, 0, s, dp);

            rt = solve(k + 1, j, 1, s, dp);
            rf = solve(k + 1, j, 0, s, dp);

            if (eval(1, 1, s.charAt(k)) == (req == 1))
                ans += lt * rt;
            if (eval(1, 0, s.charAt(k)) == (req == 1))
                ans += lt * rf;
            if (eval(0, 1, s.charAt(k)) == (req == 1))
                ans += lf * rt;
            if (eval(0, 0, s.charAt(k)) == (req == 1))
                ans += lf * rf;
        }
        return dp[i][j][req] = ans;
    }

    public static int countWays(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][2];

        for (int[][] mat : dp) {
            for (int[] row : mat)
                Arrays.fill(row, -1);
        }

        return solve(0, n - 1, 1, s, dp);
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
