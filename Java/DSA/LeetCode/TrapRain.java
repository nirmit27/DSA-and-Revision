package LeetCode;
/* 
LeetCode problem #42 solution
Link : https://leetcode.com/problems/trapping-rain-water/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class TrapRain {
    public static int trap(ArrayList<Integer> arr) {
        if (arr.size() == 0)
            return 0;
        int res = 0;

        int left = 0;
        int maxLeft = arr.get(left);

        int right = arr.size() - 1;
        int maxRight = arr.get(right);

        while (left < right) {
            if (maxLeft < maxRight) {
                left += 1;
                maxLeft = Math.max(maxLeft, arr.get(left));
                res += maxLeft - arr.get(left);
            } else {
                right -= 1;
                maxRight = Math.max(maxRight, arr.get(right));
                res += maxRight - arr.get(right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the map size : ");
            n = sc.nextInt();

            System.out.print("\nEnter the elevation map : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = trap(arr);
        System.out.println(String.format("\nAmount of trapped rain water : %d", result));
    }
}
