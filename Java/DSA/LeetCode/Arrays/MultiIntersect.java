package LeetCode.Arrays;
/* 
LeetCode problem #2248 solution
Link : https://leetcode.com/problems/intersection-of-multiple-arrays/
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class MultiIntersect {
    public static void display(ArrayList<Integer> result) {
        if (result.size() == 0) {
            System.out.println("No intersections found.");
            return;
        }
        System.out.print("\nIntersections : ");
        for (int a : result)
            System.out.print(a + " ");
    }

    public static ArrayList<Integer> findIntersections(int[][] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] row : arr) {
            for (int n : row)
                map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == arr.length)
                result.add(key);
        }

        Collections.sort(result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>(), temp = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of arrays : ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                System.out.print(String.format("\nEnter the size of sub-array #%d : ", i + 1));
                int m = sc.nextInt();
                temp = new ArrayList<>();

                System.out.print(String.format("Enter the elements of sub-array #%d : ", i + 1));
                for (int j = 0; j < m; j++)
                    temp.add(sc.nextInt());
                input.add(temp);
            }
        }
        result = findIntersections(
                input.stream().map(u -> u.stream().mapToInt(i -> i).toArray()).toArray(int[][]::new));
        display(result);
    }
}
