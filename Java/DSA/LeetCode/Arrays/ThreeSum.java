package LeetCode.Arrays;
/* 
LeetCode problem #15 solution
Link : https://leetcode.com/problems/3sum/
 */

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeSum {
    static void displayTriplets(List<List<Integer>> triplets, int target) {
        if (triplets.size() == 0)
            System.out.println("\nNo triplets found!");

        System.out.println(String.format("\nTriplets that sum up to %d are :", target));
        for (List<Integer> triplet : triplets) {
            System.out.print("[");
            for (int i : triplet) {
                System.out.print(" " + i);
            }
            System.out.println(" ]");
        }
    }

    static List<List<Integer>> findTriplets(List<Integer> arr, int target) {
        if (arr.size() < 3)
            return new ArrayList<>();

        Collections.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            if (i > 0 && arr.get(i) == arr.get(i - 1))
                continue;
            int j = i + 1, k = arr.size() - 1;

            while (j < k) {
                int sum = arr.get(i) + arr.get(j) + arr.get(k);

                if (sum == target) {
                    ans.add(Arrays.asList(arr.get(i), arr.get(j), arr.get(k)));

                    while (j < k && arr.get(j) == arr.get(j + 1))
                        j++;
                    while (j < k && arr.get(k) == arr.get(k - 1))
                        k--;
                    j++;
                    k--;
                } else if (sum < target)
                    j++;
                else
                    k--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int size, target;
        List<List<Integer>> ans;
        List<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            size = sc.nextInt();
            System.out.print("\nEnter the array elements : ");
            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the target : ");
            target = sc.nextInt();
        }
        ans = findTriplets(arr, target);
        displayTriplets(ans, target);
    }
}
