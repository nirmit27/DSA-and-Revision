/* 
LeetCode problem #20 solution
Link : https://leetcode.com/problems/valid-parentheses/
 */

import java.util.Stack;
import java.util.Scanner;

class ValidPara {
    public static boolean validPair(Character open, Character close){
        return ((open == '(' && close == ')') 
             || (open == '{' && close == '}')
             || (open == '[' && close == ']'));
    }

    public static boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();

        for(Character ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!validPair(top, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
      String input;
      try(Scanner sc = new Scanner(System.in)){
        System.out.print("\nEnter the string : ");
        input = sc.next();
      }
      if(isValid(input)) System.out.println("\nVALID");
      else System.out.println("\nINVALID");
    }
}
