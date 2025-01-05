package GfG.Hashing;
/* 
GfG problem - "Group Shifted String" solution
Link : https://www.geeksforgeeks.org/problems/group-shifted-string/1
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class GroupShifts {
    public static String generateHash(String s) {
        int shift = s.charAt(0) - 'a';
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            chars[i] = (char) (chars[i] - shift);
            if (chars[i] < 'a')
                chars[i] += 26; // wrap-around for underflow
        }
        return new String(chars);
    }

    public static void solve(String[] strs) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        String hash;

        for (String str : strs) {
            hash = generateHash(str);
            if (!map.containsKey(hash)) {
                map.put(hash, res.size());
                res.add(new ArrayList<>());
            }
            res.get(map.get(hash)).add(str);
        }

        System.out.println("\n--- Grouped Strings (based on hash) ---\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.print(String.format("Hash : %s\t->\t[ ", entry.getKey()));
            for (String x : res.get(entry.getValue()))
                System.out.print(x + " ");
            System.out.println("]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n;
        String[] strs;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of strings : ");
            n = sc.nextInt();
            strs = new String[n];

            System.out.print("Enter the strings : ");
            for (int i = 0; i < n; i++)
                strs[i] = sc.next();
        }
        solve(strs);
    }
}
