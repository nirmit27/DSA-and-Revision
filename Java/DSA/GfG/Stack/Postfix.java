package GfG.Stack;
/*
GfG problem - "Evaluation of Postfix Expression" solution
Link : https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
 */

import java.util.Stack;
import java.util.Scanner;

public class Postfix {
    public static int postfixEval(String[] exp) {
        int op1, op2;
        String integerRegex = "-?\\d+";
        Stack<Integer> st = new Stack<>();

        for (String token : exp) {
            if (token.matches(integerRegex))
                st.push(Integer.parseInt(token));
            else {
                op1 = st.pop();
                op2 = st.pop();

                switch (token) {
                    case "+":
                        st.push(op2 + op1);
                        break;
                    case "-":
                        st.push(op2 - op1);
                        break;
                    case "*":
                        st.push(op2 * op1);
                        break;
                    case "/":
                        st.push(op2 / op1);
                        break;
                }
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        int res;
        String s;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the postfix expression : ");
            s = sc.nextLine().strip();
        }

        res = postfixEval(s.split("\\s+"));
        System.out.println(String.format("\n(%s) = %d\n", s, res));
    }
}
