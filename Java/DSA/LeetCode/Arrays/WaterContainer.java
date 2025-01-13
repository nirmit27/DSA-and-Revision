package LeetCode.Arrays;
/* 
LeetCode problem #11 solution
Link : https://leetcode.com/problems/container-with-most-water/
 */

import java.util.Scanner;

public class WaterContainer {
    public static int trap(int[] arr) {
        if (arr.length <= 1)
            return 0;

        int ans = 0;
        int left = 0, right = arr.length - 1;

        while (left < right) {
            ans = Math.max(ans, (right - left) * Math.min(arr[left], arr[right]));
            if (arr[left] < arr[right])
                left++;
            else
                right--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n;
        int[] arr;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the heights : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nMaximum amount of water storage : %d\n", trap(arr)));
    }
}
