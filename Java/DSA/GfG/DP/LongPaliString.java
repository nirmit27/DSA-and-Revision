package GfG.DP;
/* 
GfG problem - "Longest String Chain" solution
Link : https://www.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 */

public class LongPaliString {
    private static String solve(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        String odd, even;
        String res = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            odd = solve(i, i, s);
            even = solve(i, i + 1, s);

            if (odd.length() > res.length())
                res = odd;
            if (even.length() > res.length())
                res = even;
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
