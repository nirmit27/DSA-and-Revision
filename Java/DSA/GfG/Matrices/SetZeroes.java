package GfG.Matrices;
/* 
GfG problem - "Set Matrix Zeroes" solution
Link : https://www.geeksforgeeks.org/problems/set-matrix-zeroes/1
 */

public class SetZeroes {
    public static void setZeroes(int[][] mat, int n, int m) {
        int fc = 1; // 1st entry of row counter

        // Setting counter values i.e. 1st row and 1st column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;

                    if (j == 0)
                        fc = 0; // skipping common value in counters
                    else
                        mat[0][j] = 0;
                }
            }
        }

        // Setting values in mat[1 .. n][1 .. m]
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] != 0) {
                    if (mat[0][j] == 0 || mat[i][0] == 0)
                        mat[i][j] = 0;
                }
            }
        }

        // Setting values in 1st row
        if (mat[0][0] == 0) {
            for (int j = 0; j < m; j++)
                mat[0][j] = 0;
        }

        // Setting values in 1st column
        if (fc == 0) {
            for (int i = 0; i < n; i++)
                mat[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        int n, m;
        int[][] matrix = MatUtils.create2DMatrix();

        n = matrix.length;
        m = matrix[0].length;

        MatUtils.displayMatrix(matrix, n, m, "BEFORE");
        setZeroes(matrix, n, m);
        MatUtils.displayMatrix(matrix, n, m, "BEFORE");
    }
}
