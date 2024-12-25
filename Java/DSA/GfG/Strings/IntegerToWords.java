package GfG.Strings;
/* 
GfG problem - "Integer to Words" solution
Link : https://www.geeksforgeeks.org/problems/number-to-words0335/0
 */

import java.util.Scanner;

public class IntegerToWords {
    static String solve(int[] values, String[] words, int n) {
        int value;
        String res = "", word;
        
        for (int i = 0; i < values.length; i++) {
            value = values[i];
            word = words[i];
            
            if (n >= value) {
                if (n >= 100)
                    res += solve(values, words, n / value) + " ";
                res += word;
                if (n % value > 0)
                    res += " " + solve(values, words, n % value);
                    
                return res;
            }
        }
        return res;
    }
    
    static String integerToWords(int n) {
        if (n == 0)
            return "Zero";
        
        int[] values = {
            1000000000, 1000000, 1000, 100, 90, 80, 70,
            60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14,
            13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
        };
        
        String[] words = {
            "Billion", "Million", "Thousand", "Hundred",
            "Ninety", "Eighty", "Seventy", "Sixty", "Fifty",
            "Forty", "Thirty", "Twenty", "Nineteen",
            "Eighteen", "Seventeen", "Sixteen", "Fifteen",
            "Fourteen", "Thirteen", "Twelve", "Eleven",
            "Ten", "Nine", "Eight", "Seven", "Six", "Five",
            "Four", "Three", "Two", "One"
        };
        
        return solve(values, words, n);
    }
    
    public static void main(String[] args) {
        int n;
        String res;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number : ");
            n = sc.nextInt();
        }
        res = integerToWords(n);
        if (res != "")
            System.out.println(String.format("\n%d  =>  %s", n, res));
        else
            System.out.println("\nNaN");
    }
}
