package GfG.Hashing;
/* 
    --- GfG Problems ---
    #1 : 4 Sum – Count quadruplets with given sum" solution
    Link : https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1

    #2 : "4 Sum - All Quadruples" solution
    Link : https://www.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
 */

import java.util.Set;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class FourSum {
    public static void displayQuads(List<List<Integer>> list) {
        if (list.size() < 1) {
            System.out.println("\nNo solution found.\n");
            return;
        }

        System.out.print("\nPossible quadruplets : < ");
        for (List<Integer> row : list) {
            System.out.print(row + " ");
        }
        System.out.println(">\n");
    }

    // Problem #1
    public static int countQuads(int[] arr, int target) {
        if (arr.length < 4)
            return 0;
        if (arr.length == 4)
            return Arrays.stream(arr).sum() == target ? 1 : 0;

        int ans = 0, n = arr.length, temp = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) { // THIRD element
            for (int j = i + 1; j < n; j++) { // FOURTH element
                temp = arr[i] + arr[j];
                ans += map.getOrDefault(target - temp, 0);
            }
            for (int k = 0; k < i; k++) { // <1st, 2nd> pair
                temp = arr[k] + arr[i];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return ans;
    }

    // Problem #2 - Two Pointer approach : O(1) space complexity
    public static void findQuadsTP(int[] arr, int target, List<List<Integer>> res) {
        if (arr.length < 4)
            return;

        long sum = 0;
        Arrays.sort(arr);
        int n = arr.length, l = 0, r = 0;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                l = j + 1;
                r = n - 1;

                while (l < r) {
                    sum = (long) arr[i] + arr[j] + arr[l] + arr[r];

                    if (sum == target) {
                        res.add(Arrays.asList(arr[i], arr[j], arr[l], arr[r]));
                        l++;
                        r--;

                        while (l < r && arr[l] == arr[l - 1])
                            l++;
                        while (l < r && arr[r] == arr[r + 1])
                            r--;
                    } else if (sum < target)
                        l++;
                    else
                        r--;
                }
            }
        }
    }

    // Problem #2 - Hashing approach : O(n) space complexity
    public static void findQuadsHash(int[] arr, int target, List<List<Integer>> res) {
        if (arr.length < 4)
            return;

        Arrays.sort(arr);
        Set<Integer> set;
        List<Integer> temp;

        long val = 0;
        int n = arr.length;
        Set<List<Integer>> resSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set = new HashSet<>();

                for (int k = j + 1; k < n; k++) {
                    val = target - (arr[i] + arr[j] + arr[k]);

                    if (set.contains((int) val)) {
                        temp = Arrays.asList(arr[i], arr[j], arr[k], (int) val);
                        Collections.sort(temp);
                        resSet.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        res.addAll(resSet);
    }

    public static void main(String[] args) {
        int[] arr;
        int n, target;
        List<List<Integer>> res = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the target sum : ");
            target = sc.nextInt();
            System.out.print("Enter the array size : ");
            n = sc.nextInt();
            arr = new int[n];

            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nPossible number of quadruplets : %d", countQuads(arr, target)));
        findQuadsHash(arr, target, res);
        displayQuads(res);
    }
}
