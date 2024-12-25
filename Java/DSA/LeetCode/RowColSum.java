package LeetCode;
/*
LeetCode problem #1605 solution
Link : https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 */

import java.util.Scanner;

public class RowColSum {
    public static void displayMatrix(int[][] matrix, int n, int m) {
        System.out.println("\nResulting matrix :");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] solution(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int temp = Integer.MAX_VALUE;

        int[][] res = new int[n][m];
        int[] row;

        for (int i = 0; i < n; i++) {
            row = new int[m];
            for (int j = 0; j < m; j++) {
                temp = Math.min(rowSum[i], colSum[j]);
                row[j] = temp;

                rowSum[i] -= temp;
                colSum[j] -= temp;
            }
            res[i] = row;
        }
        return res;
    }

    public static void main(String[] args) {
        int n, m;
        int[][] res;
        int[] rows, cols;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of rows : ");
            n = sc.nextInt();
            rows = new int[n];

            System.out.print("Enter the row sums : ");
            for (int i = 0; i < n; i++)
                rows[i] = sc.nextInt();

            System.out.print("Enter the number of columns : ");
            m = sc.nextInt();
            cols = new int[m];

            System.out.print("Enter the column sums : ");
            for (int j = 0; j < m; j++)
                cols[j] = sc.nextInt();
        }
        res = solution(rows, cols);
        displayMatrix(res, n, m);
    }
}
