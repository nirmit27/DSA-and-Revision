package GfG.Matrices;
/* 
GfG problem - "Rotate a Matrix by 180 Counterclockwise" solution
Link : https://www.geeksforgeeks.org/problems/set-matrix-zeroes/1
 */

public class Rotate180 {
    private static void swap(int[][] mat, int i, int j, int n) {
        int temp = mat[i][j];
        mat[i][j] = mat[n - i - 1][n - j - 1];
        mat[n - i - 1][n - j - 1] = temp;
    }

    public static void rotate180(int[][] mat, int n) {
        // Swapping for EVEN dims.
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(mat, i, j, n);
            }
        }

        // Swapping for ODD dims.
        if (n % 2 == 1) {
            for (int j = 0; j < n / 2; j++) {
                swap(mat, n / 2, j, n);
            }
        }
    }

    public static void main(String[] args) {
        int n;
        int[][] mat = MatUtils.create2DMatrix();
        n = mat.length;

        MatUtils.displayMatrix(mat, n, n, "BEFORE");
        rotate180(mat, n);
        MatUtils.displayMatrix(mat, n, n, "AFTER");
    }
}
