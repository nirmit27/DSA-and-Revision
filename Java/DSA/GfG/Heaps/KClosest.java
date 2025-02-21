package GfG.Heaps;
/* 
GfG problem - "K Closest Points to Origin" solution
Link : https://www.geeksforgeeks.org/problems/k-closest-points-to-origin--172242/1
 */

import java.util.Scanner;
import java.util.PriorityQueue;

public class KClosest {
    private static void display(int[][] arr, int k) {
        if (arr.length == 0) {
            System.out.println("\nNo such points exist.");
            return;
        }

        System.out.println(String.format("\nTop-%d points closest to the ORIGIN : ", k));
        for (int[] pt : arr) {
            System.out.println(String.format("(%d, %d)", pt[0], pt[1]));
        }
        System.out.println();
    }

    private static int computeDist(int[] pt) {
        return pt[0] * pt[0] + pt[1] * pt[1];
    }

    public static int[][] kClosest(int[][] pts, int k) {
        int index = 0;
        int[][] res = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> computeDist(b) - computeDist(a));

        for (int[] pt : pts) {
            if (pq.size() < k)
                pq.offer(pt);
            else {
                if (computeDist(pt) < computeDist(pq.peek())) {
                    pq.poll();
                    pq.offer(pt);
                }
            }
        }

        while (!pq.isEmpty()) {
            int[] pt = pq.poll();
            res[index][0] = pt[0];
            res[index][1] = pt[1];

            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] pt;
        int points, k;
        int[][] arr, res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of points : ");
            points = sc.nextInt();
            sc.nextLine();

            arr = new int[points][2];
            System.out.println("\nEnter the points in this format : x y");
            for (int i = 0; i < points; i++) {
                System.out.print(String.format("Point #%d : ", i + 1));
                pt = sc.nextLine().split(" ");

                arr[i][0] = Integer.parseInt(pt[0]);
                arr[i][1] = Integer.parseInt(pt[1]);
            }

            System.out.print("\nEnter the value of 'k' : ");
            k = sc.nextInt();
        }
        res = kClosest(arr, k);
        display(res, k);
    }
}
