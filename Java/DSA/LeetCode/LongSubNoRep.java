package LeetCode;
/*
LeetCode problem #3 solution
Link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class LongSubNoRep {
    public static int ptr = 0;

    public static int mapApproach(String s) {
        if (s.length() < 1)
            return s.length();

        int ans = 0, left = 0, right = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.get(s.charAt(right)) > 1) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            if (ans < (right - left + 1)) {
                ans = right - left + 1;
                ptr = left;
            }
        }
        return ans;
    }

    public static int setApproach(String s) {
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
        result = mapApproach(input);
        System.out
                .println(String.format("\nLength of the longest substring without repeating characters : %s",
                        input.substring(ptr, ptr + result)));
    }
}
