package GfG.DP;
/* 
GfG problem - "Word Break" solution
Link : https://www.geeksforgeeks.org/problems/word-break1352/1
 */

// import java.util.Scanner;

public class WordBreak {
    public boolean wordBreak(String s, String[] dictionary) {
        int n = s.length(), st;
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : dictionary) {
                st = i - word.length();

                if (st >= 0 && dp[st] && s.substring(st, st + word.length()).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
