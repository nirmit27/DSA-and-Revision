package LeetCode;
/*
LeetCode problem #3 solution
Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

import java.lang.Math;
import java.util.Scanner;

public class LongSubNoRep {
    public static int subNoRep(String s) {
        if (s.length() == 0)
            return 0;
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            for (int j = 0; j < right; j++) {
                if (s.charAt(j) == s.charAt(right))
                    left = j + 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int result = 0;
        String input;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            input = sc.nextLine();
        }
        result = subNoRep(input);
        if (result != 0)
            System.out
                    .println(String.format("\nLength of longest substring without repeating characters : %d", result));
        else
            System.out.println("\nA substring without repeating characters DOESN'T exist.");
    }
}
