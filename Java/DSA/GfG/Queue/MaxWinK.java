package GfG.Queue;
/*
GfG problem - "K Sized Subarray Maximum" solution
Link : https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class MaxWinK {
    public static ArrayList<Integer> maxWinK(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.pollLast();

            dq.addLast(i);
        }

        for (int i = k; i < n; i++) {
            res.add(arr[dq.peekFirst()]);

            while (!dq.isEmpty() && dq.peekFirst() <= (i - k))
                dq.pollFirst();

            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()])
                dq.pollLast();

            dq.add(i);
        }

        res.add(arr[dq.pollFirst()]);
        return res;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;
        ArrayList<Integer> res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.print("Enter the window size : ");
            k = sc.nextInt();
        }

        res = maxWinK(arr, k);
        System.out.println(String.format("\nMaximum elements in windows of size %d : %s\n", k, res));
    }
}
