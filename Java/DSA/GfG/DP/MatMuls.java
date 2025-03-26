package GfG.DP;
/* 
GfG problem - "Matrix Chain Multiplication" solution
Link : https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class MatMuls {
    private static int solve(int[] arr, int i, int j, int[][] memo) {
        if ((i + 1) == j)
            return 0;

        if (memo[i][j] != -1)
            return memo[i][j];

        int res = Integer.MAX_VALUE;

        for (int k = i + 1; k < j; k++)
            res = Math.min(res, solve(arr, i, k, memo) + solve(arr, k, j, memo) + arr[i] * arr[j] * arr[k]);

        return memo[i][j] = res;
    }

    public static int matMuls(int[] arr, int n) {
        if (n <= 2)
            return 0;

        if (n == 3)
            return Arrays.stream(arr).reduce(1, (a, b) -> a * b);

        int[][] memo = new int[n][n];

        for (int[] row : memo)
            Arrays.fill(row, -1);
        return solve(arr, 0, n - 1, memo);
    }

    public static void main(String[] args) {
        int n;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of indices : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the indices : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nMinimum number of operations : %d\n", matMuls(arr, n)));
    }
}
