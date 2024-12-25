package GfG.Strings;
/* 
GfG problem - "Search Pattern (KMP-Algorithm)" solution
Link : https://www.geeksforgeeks.org/problems/search-pattern0205/0
 */


import java.util.Scanner;
import java.util.ArrayList;

public class KMP {
    static void displaySolution(ArrayList<Integer> res, String text, int end) {
        if (res.size() == 0) {
            System.out.println("\n\nNo matches found!");
            return;
        }
        System.out.println("\n\nMatches found at the following indices : ");
        for (int i : res)
            System.out.println(i + " -> " + text.substring(i, i + end));
        System.out.println();
    }
    
    static void computeLps(int[] lps, String s) {
        int i = 1, l = 0;
        lps[0] = 0;
        
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(l)) {
                l++;
                lps[i] = l;
                i++;
            } else {
                if(l != 0)
                    l = lps[i - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
    
    public static ArrayList<Integer> kmp(String pat, String txt) {
        int i = 0, j = 0;
        int m = txt.length(), n = pat.length();
        
        int[] lps = new int[n];
        ArrayList<Integer> result = new ArrayList<>();
        
        computeLps(lps, pat);
        while (i < m) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                
                if (j == n) {
                    result.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String text, pattern;
        ArrayList<Integer> res;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the text : ");
            text = sc.nextLine();
            System.out.print("Enter the pattern : ");
            pattern = sc.nextLine();
        }
        res = kmp(pattern, text);
        displaySolution(res, text, pattern.length());
    }
}
