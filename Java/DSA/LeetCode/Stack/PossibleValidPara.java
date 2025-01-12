package LeetCode.Stack;
/* 
LeetCode problem #2116 solution
Link : https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/
 */

import java.util.Stack;
import java.util.Scanner;

public class PossibleValidPara {
    public static boolean approachOne(String s, String locked) {
        if (s.length() % 2 == 1)
            return false;

        Stack<Integer> free = new Stack<>();
        Stack<Integer> lock = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // Handling open parentheses
            if (locked.charAt(i) == '0')
                free.push(i);
            else if (s.charAt(i) == '(')
                lock.push(i);

            // Handling closed parentheses
            else if (s.charAt(i) == ')') {
                if (!lock.isEmpty())
                    lock.pop();
                else if (!free.isEmpty())
                    free.pop();
                else
                    return false;
            }
        }

        // Matching the remaining LOCKED '(' parentheses
        while (!free.isEmpty() && !lock.isEmpty() && free.peek() > lock.peek()) {
            free.pop();
            lock.pop();
        }

        // Checking the remaining FREE parentheses pairs
        if (lock.isEmpty() && !free.isEmpty())
            return free.size() % 2 == 0;

        return lock.isEmpty();
    }

    public static boolean approachTwo(String s, String locked) {
        if (s.length() % 2 == 1)
            return false;

        int counter = 0, n = s.length();

        // Forward traversal
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0')
                counter++;
            else
                counter--;
            if (counter < 0)
                return false;
        }
        counter = 0;

        // Reverse traversal
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0')
                counter++;
            else
                counter--;
            if (counter < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input, locked;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the parentheses string : ");
            input = sc.next();
            System.out.print("\nEnter the lock-status string : ");
            locked = sc.next();
        }
        System.out.println(
                String.format("\n%s parantheses!\n", approachOne(input, locked) ? "Possibly VALID" : "INVALID"));
    }
}
