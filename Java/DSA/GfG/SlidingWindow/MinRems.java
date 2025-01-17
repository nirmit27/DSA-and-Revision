package GfG.SlidingWindow;
/* 
GfG problem - "Minimum Removals for Target Sum" solution
Link : https://www.geeksforgeeks.org/problems/minimum-removals-for-target-sum/1
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

public class MinRems {
    public static int minRemovals(int[] arr, int k) {
        if (Arrays.stream(arr).sum() == k)
            return arr.length;

        int target = Arrays.stream(arr).sum() - k, n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = -1, temp = 0;

        for (int i = 0; i < n; i++) {
            temp += arr[i];

            if (temp == target)
                ans = i + 1;
            else if (map.containsKey(temp - target))
                ans = Math.max(ans, i - map.get(temp - target));

            if (!map.containsKey(temp))
                map.put(temp, i);
        }
        return ans == -1 ? -1 : n - ans;
    }

    public static void main(String[] args) {
        int[] arr;
        int n, k, res;

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
        res = minRemovals(arr, k);
        if (res != -1)
            System.out.println(String.format("\nMinimum number of removals needed : %d\n", res));
        else
            System.out.println("\nNo solution found.\n");
    }
}
