package LeetCode.Strings;
/* 
LeetCode problem #151 solution
Link : https://leetcode.com/problems/reverse-words-in-a-string/
 */

import java.util.Scanner;

public class ReverseWords {
    static String reverse(String str) {
        String res = "";
        String[] words = str.trim().split("[\s]+");

        for (int i = words.length - 1; i > 0; i--) {
            res += words[i] + " ";
        }
        return res + words[0];
    }

    public static void main(String[] args) {
        String input, result;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the sentence : ");
            input = sc.nextLine();
        }
        result = reverse(input);
        System.out.println(String.format("\nReversed words : %s", result));
    }
}