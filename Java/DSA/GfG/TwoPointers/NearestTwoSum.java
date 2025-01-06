package GfG.TwoPointers;
/* 
GfG problem - "Sum Pair closest to target" solution
Link : https://www.geeksforgeeks.org/problems/pair-in-array-whose-sum-is-closest-to-x1124/1
 */

import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class NearestTwoSum {
    private static int findClosest(int[] arr, int left, int right, int k) {
        int res = arr[left];
        int mid = left + (right - left) / 2;

        while (left <= right) {
            if (Math.abs(res - k) > Math.abs(arr[mid] - k))
                res = arr[mid];
            if (Math.abs(res - k) == Math.abs(arr[mid] - k))
                res = Math.max(arr[mid], res);

            if (arr[mid] == k)
                return arr[mid];
            else if (arr[mid] < k)
                left = mid + 1;
            else
                right = mid - 1;

            mid = left + (right - left) / 2;
        }
        return res;
    }

    public static List<Integer> nearestTwoSum(int[] arr, int target) {
        if (arr.length == 1)
            return new ArrayList<>();

        int n = arr.length, comp = 0, closest = 0;
        int minDiff = Integer.MAX_VALUE, currDiff;
        List<Integer> res = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            comp = target - arr[i];
            closest = findClosest(arr, i + 1, n - 1, comp);

            currDiff = Math.abs(target - arr[i] - closest);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                res = List.of(arr[i], closest);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;
        List<Integer> res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the target sum : ");
            k = sc.nextInt();
            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = nearestTwoSum(arr, k);
        if (res.size() != 2)
            System.out.println("\nNo pairs found.\n");
        else
            System.out.println("\nResult pair : " + res + "\n");
    }
}
