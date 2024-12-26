package GfG.Matrices;
/* 
GfG problem - "Create a spiral matrix of N*M size from given array" solution
Link : https://www.geeksforgeeks.org/problems/create-a-spiral-matrix-of-nm-size-from-given-array/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class MakeSpiral {
    public static int[][] makeSpiral(int[] arr, int n, int m) {
        int[][] res = new int[n][m];
        for (int[] row : res)
            Arrays.fill(row, -1);

        // Directions : Right -> Down -> Left -> Top
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int dirIndex = 0;

        int index = 0;
        int row = 0, col = 0;
        int nRow = 0, nCol = 0;

        while (index < arr.length) {
            res[row][col] = arr[index++];

            nRow = row + dir[dirIndex][0];
            nCol = col + dir[dirIndex][1];

            if (nRow < 0 || nRow == n || nCol < 0 || nCol == m || res[nRow][nCol] != -1)
                dirIndex = (dirIndex + 1) % 4;

            row += dir[dirIndex][0];
            col += dir[dirIndex][1];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] dims, arr;

        try (Scanner sc = new Scanner(System.in)) {
            dims = MatUtils.dimsInput(sc);
            System.out.println();
            arr = MatUtils.arrayInput(sc);
        }

        int[][] mat = makeSpiral(arr, dims[0], dims[1]);
        MatUtils.displayMatrix(mat, dims[0], dims[1],
                String.format("SPIRAL MATRIX of order (%d x %d)", dims[0], dims[1]));
    }
}
