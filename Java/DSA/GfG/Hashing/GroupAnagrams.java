package GfG.Hashing;
/* 
GfG problem - "Print Anagrams Together" solution
Link : https://www.geeksforgeeks.org/problems/print-anagrams-together/1
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class GroupAnagrams {
    public static void displayGroups(ArrayList<ArrayList<String>> groups) {
        if (groups == null || groups.size() == 0) {
            System.out.println("No anagrams found.");
            return;
        }
        System.out.println("\nAnagrams: ");
        if (groups.size() == 1) {
            for (String word : groups.get(0))
                System.out.print(word + " ");
            System.out.println();
            return;
        }
        for (ArrayList<String> group : groups) {
            for (String word : group) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<String>> groupAnagrams(String[] words) {
        if (words == null || words.length == 0)
            return new ArrayList<>();
        if (words.length == 1) {
            ArrayList<ArrayList<String>> res = new ArrayList<>();
            res.add(new ArrayList<>(Arrays.asList(words)));
            return res;
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        String sorted;
        char[] chars;

        for (String word : words) {
            chars = word.toCharArray();
            Arrays.sort(chars);

            sorted = new String(chars);
            map.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        int n;
        String[] words;
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of words : ");
            n = sc.nextInt();
            words = new String[n];

            System.out.print("Enter the words : ");
            for (int i = 0; i < n; i++)
                words[i] = sc.next();
        }
        groups = groupAnagrams(words);
        displayGroups(groups);
    }
}
