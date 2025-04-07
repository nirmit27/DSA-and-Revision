package GfG.Graphs;
/* 
    --- GfG Problems ---
    #1 : "DFS of Graph" solution
    Link : https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

    #2 : "BFS of graph" solution
    Link : https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

    #3 : "Topological sort" solution
    Link : https://www.geeksforgeeks.org/problems/topological-sort/1
*/

import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;

public class Traversals {
    // Problem #3 - Topological sort [DIRECTED]
    private static void topoSortUtil(int src, ArrayList<Integer>[] adjList, boolean[] visited, Stack<Integer> stack) {
        visited[src] = true;

        for (int ngbr : adjList[src]) {
            if (!visited[ngbr])
                topoSortUtil(ngbr, adjList, visited, stack);
        }
        
        stack.push(src);
    }

    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer>[] adjList = new ArrayList[V];
        ArrayList<Integer> res = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step #1 : Construct the adjacency list.
        for (int i = 0; i < V; i++)
            adjList[i] = new ArrayList<>();

        for (int[] edge : edges)
            adjList[edge[0]].add(edge[1]);

        // Step #2 : Traverse the graph via DFS.
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                topoSortUtil(i, adjList, visited, stack);
        }

        // Step #3 : Reverse the stack.
        while (!stack.isEmpty())
            res.add(stack.pop());

        return res;
    }

    // Problem #2 - BFS Traversal [UNDIRECTED]
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

    // Problem #1 - DFS Traversal [UNDIRECTED]
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
