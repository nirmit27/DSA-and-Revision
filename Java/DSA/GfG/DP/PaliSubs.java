package GfG.DP;
/* 
GfG problem - "Palindrome SubStrings" solution
Link : https://www.geeksforgeeks.org/problems/count-palindrome-sub-strings-of-a-string0652/1
 */

import java.util.Scanner;

public class PaliSubs {
    public static int paliSubs(String s) {
        int ans = 0, n = s.length(), j;
        boolean[][] dp = new boolean[n][n];

        // Step 1 : Fix the 1-length substrings
        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        // Step 2 : Fix the 2-length substrings
        for (int i = 0; i < (n - 1); i++)
            if (s.charAt(i) == s.charAt(i + 1)) {
                ans++;
                dp[i][i + 1] = true;
            }

        // Step 3 : Find the (>2)-length substrings
        for (int k = 2; k < n; k++) {
            for (int i = 0; i < (n - k); i++) {
                j = i + k;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            s = sc.nextLine();
        }
        System.out.println(String.format("\nNumber of palindromic substrings (length >= 2) : %d\n", paliSubs(s)));
    }
}
