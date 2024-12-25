package Misc;
// Recursion... revisited.

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {
    static void allIndices(ArrayList<Integer> indices, int target) {
        System.out.print(String.format("\nIndices of occurence of %d : ", target));
        for (int i : indices)
            System.out.print(i + " ");
        System.out.println();
    }

    static ArrayList<Integer> linearSearchAll(ArrayList<Integer> arr, int index, int target) {
        if (arr.size() == 0)
            return new ArrayList<>();

        ArrayList<Integer> curr = new ArrayList<>();
        if (index == arr.size())
            return curr;

        if (arr.get(index) == target)
            curr.add(index);

        ArrayList<Integer> prev = linearSearchAll(arr, index + 1, target);
        curr.addAll(prev);
        return curr;
    }

    static boolean isSorted(ArrayList<Integer> arr, int index) {
        if (index == arr.size() - 1)
            return true;
        return (arr.get(index) <= arr.get(index + 1)) && isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        int n, target;
        ArrayList<Integer> ans;
        ArrayList<Integer> arr = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size : ");
            n = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
            System.out.print("\nEnter the target : ");
            target = sc.nextInt();
        }
        // Checking if the array is sorted or not ...
        if (isSorted(arr, 0))
            System.out.println(String.format("\nThe given array is sorted!"));
        else
            System.out.println(String.format("\nThe given array is NOT sorted."));

        // Linear search for all indices of an element in an array ...
        ans = linearSearchAll(arr, 0, target);
        allIndices(ans, target);
    }
}