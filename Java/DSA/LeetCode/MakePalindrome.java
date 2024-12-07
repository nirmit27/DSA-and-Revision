package LeetCode;
/* 
LeetCode problem #1312 solution
Link : https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */

import java.util.Scanner;

public class MakePalindrome {
    public static int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        String rev = new StringBuilder(s).reverse().toString();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dp[i + 1][j + 1] = (s.charAt(i) == rev.charAt(j)) ? 1 + dp[i][j] : Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
        return s.length() - dp[n][n];
    }
    
    public static void main(String[] args) {
        int res;
        String s;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the string : ");
            s = sc.nextLine();
        }
        res = minInsertions(s);
        System.out.println(String.format("\nMinimum no. of insertions needed : %d", res));
    }
}
