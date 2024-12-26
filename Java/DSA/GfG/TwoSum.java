package GfG;
/* 
GfG problem - "Count pairs with given sum" solution
Link : https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1
 */

import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class TwoSum {
    public static int hashMapApproach(int[] arr, int target) {
        int counter = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            if (map.containsKey(target - a))
                counter += map.get(target - a);
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        return counter;
    }

    public static int twoPointerApproach(int[] arr, int target) {
        Arrays.sort(arr);
        int counter = 0, left = 0, right = arr.length - 1, sum = 0;

        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum < target)
                left++;
            else if (sum > target)
                right--;
            else {
                int l = arr[left], r = arr[right], lc = 0, lr = 0;

                // Count the occurences of 1st element of pair
                while (left <= right && arr[left] == l) {
                    lc++;
                    left++;
                }
                // Count the occurences of 2nd element of pair
                while (left <= right && arr[right] == r) {
                    lr++;
                    right--;
                }
                counter += (l == r) ? (lc * (lc - 1)) / 2 : lc * lr;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] arr;
        int n, res1, res2, target;
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
        res2 = hashMapApproach(arr, target);
        res1 = twoPointerApproach(arr, target);
        System.out.println(String.format("Number of pairs with sum %d found : %d", target, (res1 == res2) ? res1 : 0));
    }
}
