package LeetCode.Arrays;
/* 
LeetCode problem #238 solution
Link : https://leetcode.com/problems/product-of-array-except-self/
 */

import java.util.Scanner;

public class ProdExceptSelf {
    public static int[] prodExceptSelf(int[] arr) {
        int p1 = 1, p2 = 1, n = arr.length;
        int[] res = new int[n];

        // FORWARD pass
        for (int i = 0; i < n; i++) {
            res[i] = p1;
            p1 *= arr[i];
        }

        // BACKWARD pass
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= p2;
            p2 *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int n;
        int[] arr, res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the array elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = prodExceptSelf(arr);
        System.out.print("\nThe product of all elements except self is : [");
        for (int i : res)
            System.out.print(" " + i);
        System.out.println(" ]\n");
    }
}
