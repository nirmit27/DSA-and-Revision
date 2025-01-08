package GfG.TwoPointers;
/* 
GfG problem - "Indexes of Subarray Sum" solution
Link : https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class IndexedSub {
    public static void displayResults(ArrayList<Integer> result, int[] arr) {
        if (result.size() <= 1) {
            System.out.println("\nNo subarrays found.\n");
            return;
        }
        System.out.println(String.format("\n1-based Indices Range -> [%d, %d]\n", result.getFirst(), result.getLast()));
    }

    public static ArrayList<Integer> computeIndices(int[] arr, int target) {
        if (arr.length < 1)
            return new ArrayList<>(Arrays.asList(-1));
        if (arr.length == 1)
            return (arr[0] == target) ? new ArrayList<>(Arrays.asList(1, 1)) : new ArrayList<>(Arrays.asList(-1));

        int start = 0, end = 0, sum = 0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum >= target) {
                end = i;
                while (sum > target && start < end) {
                    sum -= arr[start];
                    start++;
                }
                if (sum == target) {
                    res.add(start + 1);
                    res.add(end + 1);
                    return res;
                }
            }
        }
        res.add(-1);
        return res;
    }

    public static void main(String[] args) {
        int n, target;
        int[] arr;
        ArrayList<Integer> res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the target sum : ");
            target = sc.nextInt();
            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = computeIndices(arr, target);
        displayResults(res, arr);
    }
}
