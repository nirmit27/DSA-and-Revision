package LeetCode.Searching;
/* 
LeetCode problem #169 solution - Moore's Voting algorithm
Link : https://leetcode.com/problems/majority-element/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class MooreVoting {
    public static int majority(ArrayList<Integer> arr) {
        if (arr.size() == 0)
            return -1;
        if (arr.size() == 1)
            return arr.get(0);

        int count = 0;
        int candidate = -1;

        for (int i = 0; i < arr.size(); i++) {
            if (count == 0) {
                candidate = arr.get(i);
                count++;
            } else if (arr.get(i) == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int size, result;
        ArrayList<Integer> arr = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size : ");
            size = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = majority(arr);
        if (result != -1)
            System.out.println(String.format("\nMajority element : %d", result));
        else
            System.out.println("\nMajority element DOESN'T exist.");
    }
}
