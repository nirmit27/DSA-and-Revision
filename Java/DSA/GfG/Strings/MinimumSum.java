package GfG.Strings;
/* 
GfG problem - "Minimum sum" solution
Link : https://www.geeksforgeeks.org/problems/minimum-sum4058/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSum {
    public static String addStrings(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0)
                carry += s1.charAt(i--) - '0';
            if (j >= 0)
                carry += s2.charAt(j--) - '0';
            res.append(carry % 10);
            carry = carry / 10;
        }

        // Removing trailing zeroes ...
        while (res.length() > 0 && res.charAt(res.length() - 1) == '0')
            res.deleteCharAt(res.length() - 1);

        return res.reverse().toString();
    }

    public static String minimumSum(int[] arr) {
        Arrays.sort(arr);

        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
                even.append(arr[i]);
            else
                odd.append(arr[i]);
        }
        return addStrings(even.toString(), odd.toString());
    }

    public static void main(String[] args) {
        int n;
        int[] arr;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of array : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nMinimum Sum : %s", minimumSum(arr)));
    }
}
