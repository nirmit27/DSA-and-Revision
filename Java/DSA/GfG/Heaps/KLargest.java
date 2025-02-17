package GfG.Heaps;
/* 
GfG problem - "k largest elements" solution
Link : https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest {
    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++)
            minHeap.add(arr[i]);

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }

        while (!minHeap.isEmpty()) {
            ans.add(minHeap.peek());
            minHeap.poll();
        }

        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;
        ArrayList<Integer> result;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the value of 'k' : ");
            k = sc.nextInt();

            System.out.print("Enter the array size : ");
            n = sc.nextInt();
            arr = new int[n];

            System.out.print("Enter the array elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }

        result = kLargest(arr, k);
        if (result.size() == 0)
            System.out.println(String.format("\nNO solution found for k = %d in given input.\n", k));
        else {
            System.out.println(String.format("\nTop %d elements : %s\n", k, result));
        }
    }
}
