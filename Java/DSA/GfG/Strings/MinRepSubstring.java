package GfG.Strings;
/* 
GfG problem - "Minimum repeat to make substring" solution
Link : https://www.geeksforgeeks.org/problems/minimum-times-a-has-to-be-repeated-such-that-b-is-a-substring-of-it--170645/0
 */

import java.util.Scanner;

public class MinRepSubstring {
    static boolean kmpSearch(String txt, String pat, int[] lps, int reps) {
        int n = txt.length(), m = pat.length();
        int i = 0, j = 0;

        while (i < n * reps) {
            if (txt.charAt(i % n) == pat.charAt(j)) {
                i++;
                j++;

                if (j == m)
                    return true;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return false;
    }

    static int minReps(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] lps = StringUtils.computeLps(s2);
        int x = (m + n - 1) / n;

        if (kmpSearch(s1, s2, lps, x))
            return x;

        if (kmpSearch(s1, s2, lps, x + 1))
            return x + 1;

        return -1;
    }

    public static void main(String[] args) {
        int res;
        String s1, s2;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the first string : ");
            s1 = sc.nextLine();
            System.out.print("Enter the second string : ");
            s2 = sc.nextLine();
        }
        res = minReps(s1, s2);
        if (res != -1)
            System.out.println(String.format("\nNumber of repetitions : %d", res));
        else
            System.out.println("\nNo solution found!");
    }
}
