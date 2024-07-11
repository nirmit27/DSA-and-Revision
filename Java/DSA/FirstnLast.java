/* 
LeetCode problem #34 solution
Link : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class FirstnLast {
    static int solve(ArrayList<Integer> arr, int n, boolean findFirstIndex) {
        int start = 0, end = arr.size() - 1, ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (n < arr.get(mid)) {
                end = mid - 1;
            } else if (n > arr.get(mid)) {
                start = mid + 1;
            } else {
                ans = mid;
                if (findFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

    static int[] firstNLast(ArrayList<Integer> arr, int n) {
        if (arr.size() < 2) {
            if (arr.size() == 1 && arr.get(0) == n) {
                return new int[] { 0, 0 };
            } else {
                return new int[] { -1, -1 };
            }
        }

        int[] res = { -1, -1 };
        res[0] = solve(arr, n, true);
        res[1] = solve(arr, n, false);

        return res;
    }

    public static void main(String[] args) {
        int n, size;
        int[] indices = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the target element : ");
            n = sc.nextInt();
        }

        indices = firstNLast(arr, n);
        System.out.print("\nResult : ");
        for (int i : indices) {
            if (i == -1) {
                System.out.println("There are LESS than 2 occurences.");
                break;
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
