package GfG.Graphs;
/* 
    --- GfG Problems ---
    #1 : "Undirected Graph Cycle" solution
    Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

    #2 : "Directed Graph Cycle" solution
    Link : https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
*/

import java.util.ArrayList;
import java.util.List;

public class DetectCycle {
    // Problem #2 - Directed graph
    private boolean dfs(int src, List<Integer>[] adjList, boolean[] visited, boolean[] backtracker) {
        visited[src] = true;
        backtracker[src] = true;
        
        for (int ngbr : adjList[src]) {
            if (!visited[ngbr] && dfs(ngbr, adjList, visited, backtracker))
                return true;
            else if (backtracker[ngbr])
                return true;
        }
        
        // Backtrack to update parent node adjacency status.
        backtracker[src] = false;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        List<Integer>[] adjList = new ArrayList[V];
        boolean[] visited = new boolean[V];
        boolean[] backtracker = new boolean[V];
        
        // Step #1: Construct the adjacency list.
        for (int i = 0; i < V; i++)
            adjList[i] = new ArrayList<>();
            
        for (int[] edge : edges)
            adjList[edge[0]].add(edge[1]);
        
        // Step #2: Perform DFS traversal while checking for cycle.
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, adjList, visited, backtracker))
                return true;
        }
        return false;
    }

    // Problem #1 - Undirected graph
    public static boolean dfs(int src, int parent, ArrayList<Integer>[] adjList, boolean[] visited) {
        visited[src] = true;

        for (int ngbr : adjList[src]) {
            if (!visited[ngbr]) {
                if (dfs(ngbr, src, adjList, visited))
                    return true;
            } else if (ngbr != parent)
                return true;
        }

        return false;
    }

    public static boolean undirectedCycle(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer>[] adjList = new ArrayList[V];

        for (int i = 0; i < V; i++)
            adjList[i] = new ArrayList<>();

        for (int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                if (dfs(i, -1, adjList, visited))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(String.format("\nCycle : %s\n",
                (undirectedCycle(2, new int[][] { { 0, 1 } }) ? "Detected" : "NOT Detected")));
    }
}
