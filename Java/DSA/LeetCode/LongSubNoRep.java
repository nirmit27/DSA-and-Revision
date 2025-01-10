package LeetCode;
/*
LeetCode problem #3 solution
Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashSet;
import java.util.Scanner;

public class LongSubNoRep {
    public static int ptr = 0;

    public static int subNoRep(String s) {
        if (s.length() < 1)
            return s.length();

        int ans = 0, left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();

        for (right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));

            if (ans < (right - left + 1)) {
                ans = right - left + 1;
                ptr = left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int result;
        String input;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            input = sc.nextLine();
        }
        result = subNoRep(input);
        System.out
                .println(String.format("\nLength of the longest substring without repeating characters : %s",
                        input.substring(ptr, ptr + result)));
    }
}
