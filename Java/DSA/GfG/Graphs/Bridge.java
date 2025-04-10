package GfG.Graphs;
/*
GfG problem - "Bridge edge in a graph" solution
Link : https://www.geeksforgeeks.org/problems/bridge-edge-in-graph/1
 */

import java.util.ArrayList;

public class Bridge {
    private void dfs(int src, int dest, int curr, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {
        if (visited[curr])
            return;

        visited[curr] = true;

        for (int adjNode : adjList.get(curr)) {
            if (curr == src && adjNode == dest)
                continue;
            dfs(src, dest, adjNode, adjList, visited);
        }
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        dfs(c, d, c, adjList, visited);
        return !visited[d];
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}