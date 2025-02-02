package GfG.Backtracking;
/* 
GfG problem - "Possible Words From Phone Digits" solution
Link : https://www.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PhoneWords {
    private static String[] keyPad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    private static void solve(int index, int[] arr, StringBuilder prefix, ArrayList<String> res) {
        // BASE CASE - Solution found
        if (index == arr.length) {
            res.add(prefix.toString());
            return;
        }

        int digit = arr[index];
        if (digit < 2 || digit > 9) // INVALID digit
            solve(index + 1, arr, prefix, res);

        for (char ch : keyPad[digit].toCharArray()) {
            // STEP #1 : Append a character
            prefix.append(ch);

            // STEP #2 : Onto the NEXT position
            solve(index + 1, arr, prefix, res);

            // STEP #3 : BACKTRACK - Remove the last character
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public static ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();

        solve(0, arr, prefix, res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr;
        String[] input;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the digits : ");
            input = sc.nextLine().split(" ");

            arr = new int[input.length];
            for (int i = 0; i < input.length; i++)
                arr[i] = Integer.parseInt(input[i]);
        }
        System.out.println("\nPossible words are : " + possibleWords(arr) + "\n");
    }
}
