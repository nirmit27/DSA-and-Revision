package GfG.Queue;
/*
GfG problem - "Longest Bounded-Difference Subarray" solution
Link : https://www.geeksforgeeks.org/problems/longest-bounded-difference-subarray/1
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class LongBDSub {
    public static ArrayList<Integer> longBDSub(int[] arr, int k) {
        int left = 0, size = 0, n = arr.length, a;
        ArrayDeque<Integer> inc = new ArrayDeque<>();
        ArrayDeque<Integer> dec = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        for (int right = 0; right < n; right++) {
            a = arr[right];

            while (inc.size() > 0 && inc.peekLast() > a)
                inc.pollLast();
            inc.offerLast(a);

            while (dec.size() > 0 && dec.peekLast() < a)
                dec.pollLast();
            dec.offerLast(a);

            while (!dec.isEmpty() && !inc.isEmpty() && (dec.peekFirst() - inc.peekFirst()) > k) {
                if (dec.peekFirst() == arr[left])
                    dec.pollFirst();
                if (inc.peekFirst() == arr[left])
                    inc.pollFirst();
                left++;
            }

            if ((right - left + 1) > size) {
                size = right - left + 1;
                res = new ArrayList<>(Arrays.stream(arr, left, right + 1).boxed().toList());
            }
        }
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

            System.out.print("Enter the limit : ");
            k = sc.nextInt();
        }

        res = longBDSub(arr, k);
        System.out.println(String.format("\nLongest subarray with bounded difference = %d : %s\n", k, res));
    }
}
