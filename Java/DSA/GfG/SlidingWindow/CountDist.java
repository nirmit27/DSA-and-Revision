package GfG.SlidingWindow;
/* 
GfG problem - "Count distinct elements in every window" solution
Link : https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class CountDist {
    public static void countDist(ArrayList<Integer> res, int[] arr, int k) {
        if (arr.length == 0 || k > arr.length || k <= 0)
            return;

        HashMap<Integer, Integer> map = new HashMap<>();

        // 1st window ...
        for (int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

        res.add(map.size());

        // Successive windows ...
        for (int i = k; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.getOrDefault(arr[i - k], 0) - 1);

            if (map.get(arr[i - k]) == 0)
                map.remove(arr[i - k]);

            res.add(map.size());
        }
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;
        ArrayList<Integer> res = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the window size : ");
            k = sc.nextInt();

            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        countDist(res, arr, k);
        if (res.size() > 0)
            System.out.println(String.format("\nDisinct element counts for window size %d : %s\n", k, res));
        else
            System.out.println("\nNo solution found.\n");
    }
}
