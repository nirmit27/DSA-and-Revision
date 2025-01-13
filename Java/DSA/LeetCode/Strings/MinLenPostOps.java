package LeetCode.Strings;
/*
LeetCode problem #3233 solution
Link : https://leetcode.com/problems/minimum-length-of-string-after-operations/
 */

import java.util.Scanner;

public class MinLenPostOps {
    public static int calcMinLength(String s) {
        if (s.length() <= 1)
            return s.length();

        int ans = 0;
        int[] freq = new int[26];

        for (char ch : s.toCharArray())
            freq[ch - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            ans += (freq[i] % 2 == 0) ? 2 : 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        String input;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            input = sc.nextLine();
        }
        System.out.println(String.format("\nMinimum length of string after operations : %d\n", calcMinLength(input)));
    }
}
