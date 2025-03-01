package LeetCode.String;
/* 
LeetCode problem #3163 solution
Link : https://leetcode.com/problems/string-compression-iii/
 */

import java.util.Scanner;

public class StringComp3 {
    public static String stringComp3(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        char current;

        for (int i = 0; i < s.length();) {
            current = s.charAt(i);
            count = 0;

            while (i < s.length() && s.charAt(i) == current && count != 9) {
                i++;
                count++;
            }
            res.append(count).append(current);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String ip, res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            ip = sc.nextLine().strip();
        }
        res = stringComp3(ip);
        System.out.println(String.format("\nOriginal : %s -> Compressed : %s", ip, res));
    }
}
