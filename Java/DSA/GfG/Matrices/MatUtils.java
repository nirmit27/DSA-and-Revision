package GfG.Matrices;
/* Utility functions for matrix operations */

import java.util.Scanner;

public class MatUtils {
    public static void displayMatrix(int[][] matrix, int n, int m, String message) {
        System.out.println("\nMatrix Status : " + message);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public static int[][] createMatrix() {
        int n, m;
        int[][] matrix;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of rows : ");
            n = sc.nextInt();

            System.out.print("Enter the number of columns : ");
            m = sc.nextInt();

            matrix = new int[n][m];
            System.out.println("\nEnter the matrix elements :");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++)
                    matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        /*
         * createMatrix();
         * displayMatrix(matrix, n, m, "MESSAGE");
         */
    }
}
