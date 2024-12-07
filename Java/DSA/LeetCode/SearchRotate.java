package LeetCode;
/* 
LeetCode problem #33 solution
Link : https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SearchRotate {
    static int searchRotateRecursive(ArrayList<Integer> arr, int start, int end, int target) {
        if (arr.size() == 0)
            return -1;
        if (arr.size() == 1) {
            return (arr.get(0) == target) ? 0 : -1;
        }
        if (start > end)
            return -1; // Base case

        int mid = start + (end - start) / 2;
        if (arr.get(mid) == target)
            return mid;

        if (arr.get(start) <= arr.get(mid)) { // 1st sub-array
            if (target >= arr.get(start) && target < arr.get(mid)) {
                return searchRotateRecursive(arr, start, mid - 1, target);
            } else {
                return searchRotateRecursive(arr, mid + 1, end, target);
            }
        }

        if (target > arr.get(mid) && target <= arr.get(end)) { // 2nd sub-array
            return searchRotateRecursive(arr, mid + 1, end, target);
        } else {
            return searchRotateRecursive(arr, start, mid - 1, target);
        }
    }

    public static int binarySearch(ArrayList<Integer> arr, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == target) {
                return mid;
            } else if (arr.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findPivot(ArrayList<Integer> arr) {
        int start = 0, end = arr.size() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Case 1 : Pivot lies in between `start` and `end`, BEFORE `end` and at `mid`
            if (mid < end && arr.get(mid) > arr.get(mid + 1)) {
                return mid;
            }
            // Case 2 : Pivot lies in between `start` and `end`, AFTER `start` and before
            // `mid`
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

    static int searchRotate(ArrayList<Integer> arr, int n) {
        if (arr.size() == 0) {
            return -1;
        }
        int pivot = findPivot(arr);

        if (pivot == -1) {
            return binarySearch(arr, 0, arr.size() - 1, n);
        }

        if (arr.get(pivot) == n) {
            return pivot;
        } else if (n >= arr.get(0)) {
            return binarySearch(arr, 0, pivot - 1, n);
        } else if (n < arr.get(0)) {
            return binarySearch(arr, pivot + 1, arr.size() - 1, n);
        }
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
        result = searchRotateRecursive(arr, 0, arr.size() - 1, n);
        if (result != -1) {
            System.out.println(String.format("\nElement %d found at index : %d", n, result));
        } else {
            System.out.println(String.format("\n%d does not exist in the array.", n));
        }
    }
}
