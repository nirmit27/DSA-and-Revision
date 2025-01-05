package GfG.Hashing;
/* 
GfG problem - "4 Sum – Count quadruplets with given sum" solution
Link : https://www.geeksforgeeks.org/problems/count-quadruplets-with-given-sum/1
 */

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class FourSum {
    public static int solve(int[] arr, int target) {
        if (arr.length < 4)
            return 0;
        if (arr.length == 4)
            return Arrays.stream(arr).sum() == target ? 1 : 0;

        int ans = 0, n = arr.length, temp = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) { // THIRD element
            for (int j = i + 1; j < n; j++) { // FOURTH element
                temp = arr[i] + arr[j];
                ans += map.getOrDefault(target - temp, 0);
            }
            for (int k = 0; k < i; k++) { // <1st, 2nd> pair
                temp = arr[k] + arr[i];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n, target;
        int[] arr;
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
        System.out.println(String.format("\nPossible number of quadruplets : %d\n", solve(arr, target)));
    }
}
