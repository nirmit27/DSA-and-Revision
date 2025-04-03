package GfG.Graphs;
/* 
GfG problem - "Rotten Oranges" solution
Link : https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
 */

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    private boolean validMove(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public int orangesRotting(int[][] mat) {
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> q = new LinkedList<>();

        int m = mat.length, n = mat[0].length, ans = 0, x, y, l, u, v;
        int[] src;

        // Enqueue the rotten oranges ...
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2)
                    q.offer(new int[] { i, j });
            }
        }

        // Performing multi-source BFS ...
        while (!q.isEmpty()) {
            ans++;
            l = q.size();

            while (l-- > 0) {
                src = q.poll();
                x = src[0];
                y = src[1];

                for (int[] dir : dirs) {
                    u = x + dir[0];
                    v = y + dir[1];

                    if (validMove(u, v, m, n) && mat[u][v] == 1) {
                        mat[u][v] = 2;
                        q.offer(new int[] { u, v });
                    }
                }
            }
        }

        // Checking for any remaining fresh oranges ...
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1)
                    return -1;
            }
        }
        return Math.max(ans - 1, 0);
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
