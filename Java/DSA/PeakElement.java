/* 
LeetCode problem #162 solution
Link : https://leetcode.com/problems/find-peak-element/
 */

import java.util.Scanner;
import java.util.ArrayList;

public class PeakElement {
    static int peakElement(ArrayList<Integer> arr) {
        if (arr.size() <= 1) {
            return 0;
        }

        int n = arr.size();
        int start = 0, end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && mid < (n - 1) && arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
                return arr.get(mid);
            } else if (mid < (n - 1) && arr.get(mid) < arr.get(mid + 1)) {
                start++;
            } else {
                end--;
            }
        }

        if (arr.get(0) > arr.get(1)) {
            return arr.get(0);
        } else {
            return arr.get(n - 1);
        }
    }

    public static void main(String[] args) {
        int size, result;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            size = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        result = peakElement(arr);
        System.out.println(String.format("\nPeak element : %d", result));
    }
}
