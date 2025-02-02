package GfG.Backtracking;
/* 
GfG problem - "Generate IP Addresses" solution
Link : https://www.geeksforgeeks.org/problems/generate-ip-addresses/1
 */

import java.util.Scanner;
import java.util.ArrayList;

public class GenIPAddr {
    private boolean check(String x) {
        if (x.length() == 1)
            return true;

        int n = Integer.parseInt(x);
        if (x.charAt(0) == '0' || n > 255)
            return false;

        return true;
    }

    private void solve(int index, int level, String current, String s, ArrayList<String> res) {
        if (index >= s.length())
            return;

        String temp = "";
        if (level == 3) {
            // Check the LAST level
            temp = s.substring(index);

            if (temp.length() <= 3 && check(temp))
                res.add(current + temp);
            return;
        }

        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            temp += s.charAt(i);

            // RECURSIVE Call : Onto the NEXT '.' level
            if (check(temp))
                solve(i + 1, level + 1, current + temp + ".", s, res);
        }
    }

    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();

        solve(0, 0, "", s, res);
        return res;
    }

    public static void main(String[] args) {
        String s;
        ArrayList<String> res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            s = sc.next();

            GenIPAddr obj = new GenIPAddr();
            res = obj.generateIp(s);

            if (res.isEmpty())
                System.out.println("\nNo valid IP addresses found.");
            else
                System.out.print("\nAll possible IP addresses are : " + res);
        }
    }
}
