package GfG.Backtracking;
/* 
GfG problem - "N-Queen Problem" solution
Link : https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
 */

import java.util.Scanner;
import java.util.ArrayList;

public class NQueens {
    private static void solve(int col, int n, ArrayList<Integer> board, boolean[] rows,
            boolean[] du, boolean[] dl, ArrayList<ArrayList<Integer>> res) {
        if (col > n) {
            // Saving the solution configuration
            res.add(new ArrayList<>(board));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (!rows[row] && !du[row - col + n] && !dl[row + col]) {
                // Step 1 : Place the Queen
                rows[row] = du[row - col + n] = dl[row + col] = true;
                board.add(row);

                // Step 2 : Onto the NEXT column
                solve(col + 1, n, board, rows, du, dl, res);

                // Step 3: Backtrack (remove the Queen)
                board.remove(board.size() - 1);
                rows[row] = du[row - col + n] = dl[row + col] = false;
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> nQueens(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();

        // Representing the rows : 1-based index
        boolean[] rows = new boolean[n + 1];

        // Representing the UPPER diagonal positions
        boolean[] du = new boolean[2 * n + 1];

        // Representing the LOWER diagonal positions
        boolean[] dl = new boolean[2 * n + 1];

        solve(1, n, board, rows, du, dl, res);
        return res;
    }

    public static void main(String[] args) {
        int n;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of queens : ");
            n = sc.nextInt();
        }
        ans = nQueens(n);
        System.out.print("\nPossible configurations are : < ");
        for (ArrayList<Integer> config : ans)
            System.out.print(config + " ");
        System.out.println(">\n");
    }
}
