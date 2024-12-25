package Misc;
/* 
Finding the PIVOT element in a Rotated Sorted array
Explanation : https://www.youtube.com/watch?v=W9QJ8HaRvJQ&t=10395s
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Pivot {
    public static int findPivot(ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Case 1 : Pivot lies in between `start` and `end` and BEFORE `end`
            if (mid < end && arr.get(mid) > arr.get(mid + 1)) {
                return mid;
            }
            // Case 2 : Pivot lies in between `start` and `end` and AFTER `start`
            if (mid > start && arr.get(mid) < arr.get(mid - 1)) {
                return mid - 1;
            }
            // Case 3 : Look for the pivot in the 1st sorted sub-array
            else if (arr.get(mid) <= arr.get(start)) {
                end = mid - 1;
            }
            // Case 4 : Look for the pivot in the 2nd sorted sub-array
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int size, result;
        ArrayList<Integer> arr = new ArrayList<>(); // {4 5 6 7 0 1 2} -> 7 is the PIVOT.

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();

            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = findPivot(arr);
        if (result != -1) {
            System.out.println(String.format("\nPivot element %d found at index : %d", arr.get(result), result));
        } else {
            System.out.println("\nPivot element not found.");
        }
    }
}
