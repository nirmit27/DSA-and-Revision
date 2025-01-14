package GfG.PrefixSum;
/* 
GfG problem - "Equilibrium Point" solution
Link : https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
 */

import java.util.Scanner;

public class EquiPoint {
    public static int findEquilibrium(int arr[]) {
        int total = 0, suffix = 0, prefix = 0;
        for (int n : arr)
            total += n;

        for (int i = 0; i < arr.length; i++) {
            suffix = total - prefix - arr[i];

            if (prefix == suffix)
                return i;

            prefix += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int n, res;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = findEquilibrium(arr);
        if (res != -1)
            System.out.println(String.format("\nEquilibrium point : %d\n", res));
        else
            System.out.println("\nEquilibrium point could NOT be found.\n");
    }
}
