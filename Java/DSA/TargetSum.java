/* 
LeetCode problem #494 solution
Link : https://leetcode.com/problems/target-sum/
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TargetSum {
    public static int solutions(List<Integer> arr, int target) {
        int res = 0;
        // TODO 
        return res;
    }

    public static void main(String[] args) {
        int n, target, res;
        List<Integer> arr = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of array : ");
            n = sc.nextInt();
            System.out.print("\nEnter the target sum : ");
            target = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        res = solutions(arr, target);
        System.out.println(String.format("\nNo. of possible solutions : %d", res));
    }
}
