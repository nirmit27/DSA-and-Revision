/* 
LeetCode problem #852 solution
Link : https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Mountain {
    static int findPeak(ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int start = 0, end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                start = mid + 1;
            } else if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            }
        }
        return end; // or `start`
    }

    public static void main(String[] args) {
        int size, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = findPeak(arr);
        if (result != -1) {
            System.out.print(String.format("\nPeak %d found at index : %d", arr.get(result), result));
        } else {
            System.out.print("\nPeak NOT found.");
        }
    }
}
