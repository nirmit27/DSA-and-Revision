package GfG.Graphs;
/* 
GfG problem - "Find the number of islands" solution
Link : https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
 */

public class NumIslands {
    private void dfs(int i, int j, int m, int n, char[][] grid) {
        if (i < 0 || i >= m || j < 0 || j >= n)
            return;
        else if (grid[i][j] == 'L') {
            grid[i][j] = '@';

            // Vertical / Horizontal movement
            dfs(i - 1, j, m, n, grid);
            dfs(i, j - 1, m, n, grid);
            dfs(i + 1, j, m, n, grid);
            dfs(i, j + 1, m, n, grid);

            // Diagonal movement
            dfs(i - 1, j - 1, m, n, grid);
            dfs(i - 1, j + 1, m, n, grid);
            dfs(i + 1, j - 1, m, n, grid);
            dfs(i + 1, j + 1, m, n, grid);
        }
    }

    public int countIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'L') {
                    dfs(i, j, m, n, grid);
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
