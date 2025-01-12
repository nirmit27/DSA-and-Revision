package LeetCode.Graphs;
/* 
LeetCode problem #2097 solution - Finding the Eulerian Path
Link : https://leetcode.com/problems/valid-arrangement-of-edges/
 */

import java.util.*;

public class EulerianPath {
    public static int[][] eulerianPath(int[][] edges) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        Map<Integer, Integer> inOutDegree = new HashMap<>();

        for (int[] pair : edges) {
            adjacency.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            inOutDegree.merge(pair[0], 1, Integer::sum);
            inOutDegree.merge(pair[1], -1, Integer::sum);
        }

        int startNode = edges[0][0];
        for (Map.Entry<Integer, Integer> entry : inOutDegree.entrySet()) {
            if (entry.getValue() == 1) {
                startNode = entry.getKey();
                break;
            }
        }

        List<Integer> path = new ArrayList<>();
        Deque<Integer> nodeStack = new ArrayDeque<>();
        nodeStack.push(startNode);

        while (!nodeStack.isEmpty()) {
            List<Integer> neighbors = adjacency.getOrDefault(nodeStack.peek(), new ArrayList<>());
            if (neighbors.isEmpty()) {
                path.add(nodeStack.pop());
            } else {
                int nextNode = neighbors.get(neighbors.size() - 1);
                nodeStack.push(nextNode);
                neighbors.remove(neighbors.size() - 1);
            }
        }

        int pathSize = path.size();
        int[][] arrangement = new int[pathSize - 1][2];

        for (int i = pathSize - 1; i > 0; --i)
            arrangement[pathSize - 1 - i] = new int[] { path.get(i), path.get(i - 1) };
        return arrangement;
    }

    public static void display(int[][] edges) {
        System.out.print("\nEulerian Path : ");
        for (int[] edge : edges)
            System.out.print(String.format("[%d, %d] ", edge[0], edge[1]));
        System.out.println();
    }

    public static void main(String[] args) {
        int n;
        int[][] edges;
        String[] rowInput;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of edges : ");
            n = sc.nextInt();
            sc.nextLine();

            edges = new int[n][2];
            System.out.println("\nEnter the edges :");

            for (int i = 0; i < n; i++) {
                rowInput = sc.nextLine().split(" ");
                edges[i] = new int[] { Integer.parseInt(rowInput[0]), Integer.parseInt(rowInput[1]) };
            }
        }
        edges = eulerianPath(edges);
        display(edges);
    }
}
