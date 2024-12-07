package LeetCode;
/* 
LeetCode problem #1095 solution
Link : https://leetcode.com/problems/find-in-mountain-array/
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SearchMountain {
    static int orderAgnosticSearch(ArrayList<Integer> arr, int start, int end, int n) {
        boolean isAsc = arr.get(start) < arr.get(end);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) == n) {
                return mid;
            }

            if (isAsc) {
                if (n < arr.get(mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (n < arr.get(mid)) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

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
        return end;
    }

    static int searchMount(ArrayList<Integer> arr, int n) {
        if (arr == null || arr.size() == 0) {
            return -1;
        }

        int peak = findPeak(arr);
        int firstTry = orderAgnosticSearch(arr, 0, peak, n);
        int secondTry = orderAgnosticSearch(arr, peak + 1, arr.size() - 1, n);

        return (firstTry == -1) ? secondTry : firstTry;
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
            System.out.println(String.format("\nElement %d found at index : %d", n, result));
        } else {
            System.out.println(String.format("\n%d does not exist in the array.", n));
        }
    }
}
