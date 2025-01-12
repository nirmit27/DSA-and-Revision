package LeetCode.Stack;
/* 
LeetCode problem #20 solution
Link : https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;
import java.util.Scanner;

public class ValidPara {
    private static boolean validPair(Character open, Character close) {
        return ((open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']'));
    }

    public static boolean approachOne(String s) {
        if (s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();

        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else {
                if (stack.isEmpty())
                    return false;

                if (!validPair(stack.peek(), ch))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean approachTwo(String s) {
        if (s.length() % 2 != 0)
            return false;

        Stack<Character> st = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(')
                st.push(')');
            else if (ch == '[')
                st.push(']');
            else if (ch == '{')
                st.push('}');
            else if (st.isEmpty() || st.pop() != ch)
                return false;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String input;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the string : ");
            input = sc.next();
        }
        System.out.println(String.format("\n%s parentheses!\n", approachTwo(input) ? "VALID" : "INVALID"));
    }
}
