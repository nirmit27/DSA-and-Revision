package LeetCode;
/*
LeetCode problem #1143 solution
Link : https://leetcode.com/problems/longest-common-subsequence/
 */

import java.util.Scanner;

public class LCS {
    public static int solution(String text1, String text2){
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i + 1][j + 1] = (text1.charAt(i) == text2.charAt(j)) ? 1 + dp[i][j] : Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[m][n];
    }
    
    public static void main(String[] args) {
        String s1, s2;
        try (Scanner sc = new Scanner(System.in)){
            System.out.print("\nEnter the two strings : ");
            s1 = sc.next();
            s2 = sc.next();
        }
        System.out.println(String.format("\nLongest Common Subsequence = %d", solution(s1, s2)));
    }
}
