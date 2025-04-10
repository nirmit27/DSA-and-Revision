package GfG.Graphs;
/*
GfG problem - "Articulation Point - II" solution
Link : https://www.geeksforgeeks.org/problems/articulation-point2616/1
 */

import java.util.ArrayList;

public class ArticulatePoint {
    private static int timer;

    private static void dfs(int v, int u, ArrayList<ArrayList<Integer>> adjList, boolean[] visited, int[] tin,
            int[] low, boolean[] isArticulate) {
        visited[v] = true;
        tin[v] = low[v] = timer++;

        int children = 0;

        for (int n : adjList.get(v)) {
            if (n == u)
                continue;
            if (!visited[n]) {
                dfs(n, v, adjList, visited, tin, low, isArticulate);
                low[v] = Math.min(low[n], low[v]);

                if (low[n] >= tin[v] && u != -1)
                    isArticulate[v] = true;
                children++;
            } else
                low[v] = Math.min(low[v], tin[n]);
        }
        if (u == -1 && children > 1)
            isArticulate[v] = true;
    }

    public static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[V];
        boolean[] isArticulate = new boolean[V];

        int[] tin = new int[V];
        int[] low = new int[V];

        timer = 0;

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, -1, adjList, visited, tin, low, isArticulate);
        }

        for (int i = 0; i < V; i++) {
            if (isArticulate[i])
                ans.add(i);
        }

        if (ans.size() == 0)
            ans.add(-1);

        return ans;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
