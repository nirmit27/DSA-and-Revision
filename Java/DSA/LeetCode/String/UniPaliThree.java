package LeetCode.String;
/* 
LeetCode problem #1930 solution
Link : https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 */

import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;

public class UniPaliThree {
    public static int countStrings(String s) {
        if (s.length() < 3 || s == null)
            return 0;
        if (s.length() == 3)
            return s.charAt(0) == s.charAt(2) ? 1 : 0;

        int current = 0;
        Set<Integer> set = new HashSet<>();
        int[] lc = new int[26]; // count of characters in left substring
        int[] rc = new int[26]; // count of characters in right substring

        for (char ch : s.toCharArray())
            rc[ch - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i) - 'a';
            rc[current]--; // remove the current character from the right substring

            for (int j = 0; j < 26; j++) {
                if (lc[j] > 0 && rc[j] > 0)
                    set.add(current * 26 + j); // hash value for pair of matching pair in left and right substrings
            }
            lc[current]++; // add the current character to the left substring
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the string : ");
            s = sc.nextLine();
        }
        System.out.println(String.format("\nPossible length-3 palindromic substrings : %d", countStrings(s)));
    }
}
