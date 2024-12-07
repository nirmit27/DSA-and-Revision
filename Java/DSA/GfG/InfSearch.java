package GfG;
/* 
GfG problem - "Find position of an element in a sorted array of infinite numbers"
Link : https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class InfSearch {
    static int binarySearch(ArrayList<Integer> arr, int start, int end, int n) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (n < arr.get(mid)) {
                end = mid - 1;
            } else if (n > arr.get(mid)) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int infSearch(ArrayList<Integer> arr, int n) {
        int start = 0, end = 1;

        while (n > arr.get(end) && end < arr.size()) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;
            start = temp;
        }

        if (end > arr.size()) {
            end = arr.size() - 1;
        }

        return binarySearch(arr, start, end, n);
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
        result = infSearch(arr, n);
        if (result != -1) {
            System.out.print(String.format("\nElement %d found at index : %d", n, result));
        } else {
            System.out.print(String.format("\n%d does NOT exist in the array.", n));
        }
    }
}