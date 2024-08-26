/* 
LeetCode problem #649 solution
Link : https://leetcode.com/problems/dota2-senate/
 */

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Senate {
    public static String winner(String senate) {
        int position = senate.length();
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R')
                rad.add(i);
            else
                dir.add(i);
        }

        while (!rad.isEmpty() && !dir.isEmpty()) {
            if (rad.peek() < dir.peek())
                rad.add(++position);
            else
                dir.add(++position);
            rad.poll();
            dir.poll();
        }
        return (rad.isEmpty()) ? "Dire" : "Radiant";
    }

    public static void main(String[] args) {
        String senate;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the senate status : ");
            senate = sc.next();
        }
        System.out.println(String.format("\nWinning party : %s", winner(senate)));
    }
}
