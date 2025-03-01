package GfG.Stack;
/*
GfG problem - "Decode the string" solution
Link : https://www.geeksforgeeks.org/problems/decode-the-string2444/1
 */

import java.util.Stack;
import java.util.Scanner;

public class Decode {
    public static String decode(String s) {
        int n;
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder(), temp, num, rep;

        for (char c : s.toCharArray()) {
            if (c != ']')
                st.push(c); // Push all characters
            else {
                temp = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[')
                    temp.insert(0, st.pop()); // Store substrings to be repeated
                st.pop(); // Pop the '[' character

                num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek()))
                    num.insert(0, st.pop()); // Store the number of reps.

                n = Integer.parseInt(num.toString());
                rep = new StringBuilder();

                for (int j = 0; j < n; j++)
                    rep.append(temp); // Create the repeated substrings

                for (char ch : rep.toString().toCharArray())
                    st.push(ch); // Push the repetitions onto the stack
            }
        }

        while (!st.isEmpty())
            res.append(st.pop()); // Generate the final string

        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String enc, dec;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the encoded string : ");
            enc = sc.nextLine();
        }

        dec = decode(enc);
        System.out.println(String.format("\nEncoded string : %s  ->  Decoded string : %s\n", enc, dec));
    }
}