package GfG.Arrays;
/* 
GfG problem - "Form the Largest Number" solution
Link : https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class LargestNumber {
    public static String largestNumber(int[] arr) {
        String[] aux = new String[arr.length];
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < arr.length; i++)
            aux[i] = String.valueOf(arr[i]);

        // Sorting in lexicographically decreasing order after concatenation ...
        Arrays.sort(aux, (a, b) -> (b + a).compareTo(a + b));

        // If the array only contains zeroes ...
        if (aux[0].equals("0"))
            return "0";

        for (String num : aux)
            res.append(num);
        return res.toString();
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
        System.out.println(String.format("\nLargest Number : %s", largestNumber(arr)));
    }
}
