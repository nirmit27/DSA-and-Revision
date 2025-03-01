package LeetCode.String;
/* 
LeetCode problem #14 solution
Link : https://leetcode.com/problems/longest-common-prefix/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Prefix {

    public static String commonPrefix(ArrayList<String> arr) {
        if (arr == null || arr.size() == 0)
            return "";

        String prefix = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            while (arr.get(i).indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);

            if (prefix.length() == 0)
                break;
        }
        return prefix;
    }

    public static void main(String[] args) {
        int size;
        String result;
        ArrayList<String> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            System.out.print("\nEnter the words : ");
            for (int i = 0; i < size; i++) {
                String x = sc.next();
                arr.add(x);
            }
        }
        result = commonPrefix(arr);
        if (result.length() != 0)
            System.out.println(String.format("\nLongest common prefix : %s", result));
        else
            System.out.println("\nNO common prefix!");
    }
}
