package GfG.Hashing;
/* Testing the functions */

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr;
        int n, target, res;
        List<List<Integer>> resList;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the target sum : ");
            target = sc.nextInt();

            System.out.print("Enter the array size : ");
            n = sc.nextInt();
            arr = new int[n];

            System.out.print("Enter the array elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = HashSolutions.findPairs(arr, target);
        System.out.println(String.format("\nNumber of pairs with sum = %d : %d", target, res));

        resList = HashSolutions.findTriplets(arr);
        HashSolutions.displayTriplets(resList, arr);
    }
}
