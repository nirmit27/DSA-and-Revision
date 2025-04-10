package GfG.Graphs;
/*
GfG problem - "Minimum cost to connect all houses in a city" solution
Link : https://www.geeksforgeeks.org/problems/minimum-cost-to-connect-all-houses-in-a-city/1
 */

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrimsMST {
    private int manhattanDistance(int[] h1, int[] h2) {
        return Math.abs(h1[0] - h2[0]) + Math.abs(h1[1] - h2[1]);
    }

    public int minCost(int[][] houses) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int totalCost = 0, n = houses.length, cost, u, md;
        boolean[] visited = new boolean[n];
        int[] curr;

        minHeap.offer(new int[] { 0, 0 });

        while (!minHeap.isEmpty()) {
            curr = minHeap.poll();
            cost = curr[0];
            u = curr[1];

            if (visited[u])
                continue;

            visited[u] = true;
            totalCost += cost;

            for (int v = 0; v < n; v++) {
                md = manhattanDistance(houses[u], houses[v]);
                minHeap.offer(new int[] { md, v });
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
