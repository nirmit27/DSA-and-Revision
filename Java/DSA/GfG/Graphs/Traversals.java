package GfG.Graphs;
/* 
    --- GfG Problems ---
    #1 : "DFS of Graph" solution
    Link : https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

    #2 : "BFS of graph" solution
    Link : https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
*/

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Traversals {
    // Problem #2 - BFS Traversal
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size(), curr;
        boolean[] viz = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        viz[0] = true;
        q.offer(0);

        while (!q.isEmpty()) {
            curr = q.poll();
            res.add(curr);

            for (int ngbr : adj.get(curr)) {
                if (!viz[ngbr]) {
                    viz[ngbr] = true;
                    q.offer(ngbr);
                }
            }
        }
        return res;
    }

    // Problem #1 - DFS Traversal
    private void dfsUtil(ArrayList<ArrayList<Integer>> adj, boolean[] viz, ArrayList<Integer> res, int idx) {
        viz[idx] = true;
        res.add(idx);

        for (int ngbr : adj.get(idx)) {
            if (!viz[ngbr])
                dfsUtil(adj, viz, res, ngbr);
        }
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] viz = new boolean[n];
        ArrayList<Integer> res = new ArrayList<>();

        dfsUtil(adj, viz, res, 0);
        return res;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
