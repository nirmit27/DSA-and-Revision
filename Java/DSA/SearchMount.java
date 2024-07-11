/* 
LeetCode problem #1095 solution
Link : https://leetcode.com/problems/find-in-mountain-array/
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SearchMount {
    static int searchMount(ArrayList<Integer> arr, int n) {
        // TODO

        return -1;
    }

    public static void main(String[] args) {
        int n, size, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the target element : ");
            n = sc.nextInt();
        }
        result = searchMount(arr, n);
        if (result != -1) {
            System.out.println(String.format("\nIndex of %d = %d", n, result));
        } else {
            System.out.println(String.format("\n%d does not exist in the array.", n));
        }
    }
}
