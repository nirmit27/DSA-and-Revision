package GfG.Backtracking;
/* 
    --- GfG Problems ---
    #1 : "Combination Sum" solution
    Link : https://www.geeksforgeeks.org/problems/combination-sum-1587115620/1

    #2 : "Combination Sum II" solution
    Link : https://www.geeksforgeeks.org/problems/combination-sum-ii-1664263832/1
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class CombinationSum {
    private static void solveUnique(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> current, int[] arr,
            int target,
            int index) {
        if (target == 0) {
            res.add(new ArrayList<>(current));
            return;
        }

        if (target < 0 || index > arr.length)
            return;

        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1])
                continue;

            current.add(arr[i]);
            solveUnique(res, current, arr, target - arr[i], i + 1);
            current.remove(current.size() - 1);
        }
    }

    /* Problem #2 - WITHOUT repetitions */
    public static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        Arrays.sort(arr);
        solveUnique(res, current, arr, target, 0);
        return res;
    }

    private static void solve(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] arr, int rem,
            int index) {
        // BASE Case : Found a solution
        if (rem == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // Terminal Case : EXCEEDED the target OR index OUT OF BOUNDS od input
        if (rem < 0 || index >= arr.length)
            return;

        // FORWARDING -> SAME index with DEDuCTION
        temp.add(arr[index]);
        solve(res, temp, arr, rem - arr[index], index);

        // BACKTRACKING -> NEXT index WITHOUT deduction
        temp.remove(temp.size() - 1);
        solve(res, temp, arr, rem, index + 1);
    }

    /* Problem #1 - WITH repetitions */
    public static ArrayList<ArrayList<Integer>> allCombinations(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        solve(res, temp, arr, target, 0);
        return res;
    }

    public static void main(String[] args) {
        int n, target;
        int[] arr;
        ArrayList<ArrayList<Integer>> res;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of elements : ");
            n = sc.nextInt();
            arr = new int[n];

            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            System.out.print("Enter the target sum : ");
            target = sc.nextInt();

            res = uniqueCombinations(arr, target);
            if (res.isEmpty())
                System.out.println("\nNo solutions found.\n");
            else
                System.out.println("\nResulting combinations : " + res + "\n");
        }
    }
}
