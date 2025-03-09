package GfG.Heaps;
/* 
GfG problem - "Top K Frequent in Array" solution
Link : https://www.geeksforgeeks.org/problems/top-k-frequent-elements-in-array/1
 */

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.PriorityQueue;

public class TopKFreq {
    private static Comparator<int[]> compare = (a, b) -> (a[0] == b[0]) ? Integer.compare(a[1], b[1])
            : Integer.compare(a[0], b[0]);

    public static ArrayList<Integer> topKFreq(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(compare);
        HashMap<Integer, Integer> freq = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int n : arr)
            freq.put(n, freq.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            pq.offer(new int[] { entry.getValue(), entry.getKey() });

            if (pq.size() > k)
                pq.poll();
        }

        while (!pq.isEmpty())
            res.add(pq.poll()[1]);

        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;
        ArrayList<Integer> res = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of the array : ");
            n = sc.nextInt();
            arr = new int[n];

            System.out.print("\nEnter the elements of the array : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.print("\nEnter the value of 'k' : ");
            k = sc.nextInt();
        }
        res = topKFreq(arr, k);
        System.out.println(String.format("\nTop-%d frequent elements : %s\n", k, res));
    }
}
