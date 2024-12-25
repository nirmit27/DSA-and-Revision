package GfG.Matrices;
/* 
GfG problem - "Make Matrix Beautiful" solution
Link : https://www.geeksforgeeks.org/problems/make-matrix-beautiful-1587115620/1
 */

public class BeautifulMatrix {
    public static int beautifulMatrix(int[][] mat) {
        int maxSum = 0, res = 0, n = mat.length;
        int[] rowSum = new int[n], colSum = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
                maxSum = Math.max(maxSum, Math.max(rowSum[i], colSum[j]));
            }
        }

        for (int x : rowSum)
            res += maxSum - x;
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = GfG.Matrices.MatUtils.create2DMatrix();
        int n = matrix.length;
        int res;

        GfG.Matrices.MatUtils.displayMatrix(matrix, n, n, "BEFORE");
        res = beautifulMatrix(matrix);
        System.out.println(String.format("Minimum number of operations required : %d", res));
    }
}
