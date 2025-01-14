package GfG.Hashing;
/* 
    --- GfG Problems ---
    #1 : "Count pairs with given sum" solution
    Link : https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1

    #2 : "Find All Triplets with Zero Sum" solution
    Link : https://www.geeksforgeeks.org/problems/find-all-triplets-with-zero-sum/1

    #3 : "Subarrays with sum K" solution
    Link : https://www.geeksforgeeks.org/problems/subarrays-with-sum-k/1
 */

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class HashSolutions {
    public static void displayTriplets(List<List<Integer>> res, int[] arr) {
        if (res.isEmpty()) {
            System.out.println("\nNo triplets found.");
            return;
        }
        System.out.println("\nPossible zero-sum triplets :");
        for (List<Integer> triplet : res)
            System.out.println(
                    String.format("[%d, %d, %d]", arr[triplet.get(0)], arr[triplet.get(1)], arr[triplet.get(2)]));
    }

    // Problem #1
    public static int findPairs(int[] arr, int target) {
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            if (map.containsKey(target - a))
                counter += map.get(target - a);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return counter;
    }

    // Problem #2
    public static List<List<Integer>> findTriplets(int[] arr) {
        if (arr.length == 3 && Arrays.stream(arr).sum() == 0)
            return new ArrayList<List<Integer>>(List.of(Arrays.asList(0, 1, 2)));

        int n = arr.length;
        Set<ArrayList<Integer>> set = new HashSet<>();
        Map<Integer, ArrayList<int[]>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                map.computeIfAbsent(arr[i] + arr[j], key -> new ArrayList<>()).add(new int[] { i, j });
        }

        for (int k = 0; k < n; k++) {
            if (map.containsKey(-arr[k])) {
                List<int[]> pairs = map.get(-arr[k]);

                for (int[] pair : pairs) {
                    if (pair[0] != k && pair[1] != k) {
                        ArrayList<Integer> current = new ArrayList<>(Arrays.asList(pair[0], pair[1], k));
                        Collections.sort(current);
                        set.add(current);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // Problem #3
    public static int subArraySum(int[] arr, int k) {
        int total = 0, count = 0;
        Map<Integer, Integer> hm = new HashMap<>();

        hm.put(0, 1);
        for (int n : arr) {
            total += n;
            count += hm.getOrDefault(total - k, 0);
            hm.put(total, hm.getOrDefault(total, 0) + 1);
        }
        return count;
    }
}
