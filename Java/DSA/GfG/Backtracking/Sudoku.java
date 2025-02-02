package GfG.Backtracking;
/* 
GfG problem - "Solve the Sudoku" solution
Link : https://www.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
 */

import java.util.Scanner;

public class Sudoku {
    private static boolean check(int i, int j, int[][] mat, int[] row, int[] col, int[] box, int n) {
        int mask = 1 << n;

        if (((row[i] & mask) != 0) || ((col[j] & mask) != 0)
                || ((box[(i / 3) * 3 + j / 3] & mask) != 0))
            return false;

        return true;
    }

    private static boolean solve(int i, int j, int[][] mat, int[] row, int[] col, int[] box) {
        // BASE Case : Reaching the END of the MATRIX
        if (i == 8 && j == 9)
            return true;

        // Case : Reaching the END of current ROW
        if (j == 9) {
            j = 0;
            i++;
        }

        // Case : ALREADY marked cell
        if (mat[i][j] != 0)
            return solve(i, j + 1, mat, row, col, box);

        int mask = 0;

        // Loop : 1 -> 9 (Checking valid placement of numbers)
        for (int n = 1; n <= 9; n++) {
            if (check(i, j, mat, row, col, box, n)) {
                mask = 1 << n;

                // Step 1 : Place the number
                mat[i][j] = n;
                row[i] |= mask;
                col[j] |= mask;
                box[(i / 3) * 3 + j / 3] |= mask;

                // Step 2 : Onto the NEXT column
                if (solve(i, j + 1, mat, row, col, box))
                    return true;

                // Step 3 : BACKTRACK - Remove the number
                mat[i][j] = 0;
                row[i] &= ~mask;
                col[j] &= ~mask;
                box[(i / 3) * 3 + j / 3] &= ~mask;
            }
        }
        return false;
    }

    public static int[][] solveSudoku(int[][] mat) {
        int[] row = new int[9];
        int[] col = new int[9];
        int[] box = new int[9];
        int mask = 0;

        // Bit Masking to FIX the numbers ALREADY present in cells
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] != 0) {
                    mask = 1 << mat[i][j];

                    row[i] |= mask;
                    col[j] |= mask;
                    box[(i / 3) * 3 + j / 3] |= mask;
                }
            }
        }
        return solve(0, 0, mat, row, col, box) ? mat : new int[9][9];
    }

    public static void main(String[] args) {
        int[][] mat = new int[9][9];

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("\nEnter the Sudoku matrix : \n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
        }
        
    }
}
