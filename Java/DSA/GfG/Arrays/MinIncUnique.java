package GfG.Arrays;
/* 
GfG problem - "Make array elements unique" solution
Link : https://www.geeksforgeeks.org/problems/make-array-elements-unique--170645/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class MinIncUnique {
    public static int minIncrements(int[] arr) {
        Arrays.sort(arr);
        int count = 0, current = 0;

        for (int a : arr) {
            current = Math.max(current, a);
            count += current++ - a;
        }
        return count;
    }

    public static void main(String[] args) {
        int n;
        int[] arr;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of array : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nMinimum number of increments : %d", minIncrements(arr)));
    }
}
