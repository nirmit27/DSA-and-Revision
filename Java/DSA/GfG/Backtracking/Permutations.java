package GfG.Backtracking;
/* 
GfG problem - "Permutations of a String" solution
Link : https://www.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
 */

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
import java.util.ArrayList;

public class Permutations {
    private static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);
    }

    private static void solve(StringBuilder s, Set<String> ans, int index) {
        // Base Case
        if (index == s.length()) {
            ans.add(s.toString());
            return;
        }

        // State Space Tree
        for (int i = index; i < s.length(); i++) {
            swap(s, index, i);
            solve(s, ans, index + 1);
            swap(s, index, i);
        }
    }

    public static ArrayList<String> findPermutations(String s) {
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder(s);

        solve(sb, res, 0); // Recursion
        return new ArrayList<String>(res);
    }

    public static void main(String[] args) {
        String str;
        List<String> res = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            str = sc.next();
        }
        res = findPermutations(str);
        System.out.println("\nPermutations of the string are : " + res + "\n");
    }
}
