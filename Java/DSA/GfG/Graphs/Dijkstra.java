package GfG.Graphs;
/*
GfG problem - "Dijkstra Algorithm" solution
Link : https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    private List<List<List<Integer>>> constructAdjList(int V, int[][] edges) {
        List<List<List<Integer>>> adjList = new ArrayList<>();
        List<Integer> e1, e2;
        int u, v, wt;

        for (int i = 0; i < V; i++)
            adjList.add(new ArrayList<>());

        for (int[] edge : edges) {
            u = edge[0];
            v = edge[1];
            wt = edge[2];

            e1 = new ArrayList<>();
            e1.add(v);
            e1.add(wt);
            adjList.get(u).add(e1);

            e2 = new ArrayList<>();
            e2.add(u);
            e2.add(wt);
            adjList.get(v).add(e2);
        }
        return adjList;
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        int u, v, wt;
        int[] dist = new int[V];

        List<Integer> start = new ArrayList<>(), current, temp;
        List<List<List<Integer>>> adjList = constructAdjList(V, edges);
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0)));

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        start.add(0);
        start.add(src);
        minHeap.offer(start);

        while (!minHeap.isEmpty()) {
            current = minHeap.poll();
            u = current.get(1);

            for (List<Integer> ngbr : adjList.get(u)) {
                v = ngbr.get(0);
                wt = ngbr.get(1);

                if (dist[v] > (dist[u] + wt)) {
                    dist[v] = dist[u] + wt;

                    temp = new ArrayList<>();
                    temp.add(dist[v]);
                    temp.add(v);

                    minHeap.offer(temp);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
