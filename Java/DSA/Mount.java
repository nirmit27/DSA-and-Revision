/* 
LeetCode problem #852 solution
Link : https://leetcode.com/problems/peak-index-in-a-mountain-array/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Mount {
    static int findPeak(ArrayList<Integer> arr) {
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
        int size;
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
        System.out.print(String.format("\nPeak %d found at index : %d", arr.get(findPeak(arr)), findPeak(arr)));
    }
}
