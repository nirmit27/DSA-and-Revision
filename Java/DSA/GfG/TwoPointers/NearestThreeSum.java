package GfG.TwoPointers;
/* 
GfG problem - "3 Sum Closest" solution
Link : https://www.geeksforgeeks.org/problems/3-sum-closest/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class NearestThreeSum {
    public static int nearestThreeSum(int[] arr, int target) {
        if (arr.length <= 3)
            return -1;

        Arrays.sort(arr);
        int n = arr.length, l = 0, r = 0, res = 0;
        int minDiff = Integer.MAX_VALUE, currSum = 0;

        for (int i = 0; i < n - 2; i++) {
            l = i + 1;
            r = n - 1;

            while (l < r) {
                currSum = arr[i] + arr[l] + arr[r];

                if (Math.abs(target - currSum) < minDiff) {
                    minDiff = Math.abs(target - currSum);
                    res = currSum;
                } else if (Math.abs(target - currSum) == minDiff)
                    res = Math.max(res, currSum);
                
                if (currSum > target)
                    r--;
                else
                    l++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr;
        int n, k, res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the target sum : ");
            k = sc.nextInt();
            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = nearestThreeSum(arr, k);
        if (res != -1)
            System.out.println(String.format("\nNearest three sum closest to %d : %d\n", k, res));
        else
            System.out.println("\nNo triplets found.\n");
    }
}
