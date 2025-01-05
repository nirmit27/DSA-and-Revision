package GfG.TwoPointers;
/* 
GfG problem - "Count all triplets with given sum in sorted array" solution
Link : https://www.geeksforgeeks.org/problems/count-all-triplets-with-given-sum-in-sorted-array/1
 */

import java.util.Arrays;
import java.util.Scanner;

public class TripletSum {
    static int countTriplets(int[] arr, int k) {
        if (arr.length < 3)
            return 0;
        if (arr.length == 3)
            return Arrays.stream(arr).sum() == k ? 1 : 0;

        int count = 0, n = arr.length, len = 0, sum = 0, tl = 0, tr = 0;

        for (int i = 0; i < n - 2; i++) {
            int temp = k - arr[i];
            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                sum = arr[l] + arr[r];

                if (sum == temp) {
                    if (arr[l] == arr[r]) {
                        len = r - l + 1;
                        count += (len * (len - 1)) / 2;
                        break;
                    } else {
                        tl = l;
                        tr = r;

                        while (l < r && arr[l] == arr[tl])
                            l++;
                        while (l <= r && arr[r] == arr[tr])
                            r--;

                        count += (tl - l) * (r - tr);
                    }
                } else if (sum < temp)
                    l++;
                else
                    r--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n, k;
        int[] arr;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the target sum : ");
            k = sc.nextInt();
            System.out.print("Enter the array size : ");
            n = sc.nextInt();

            arr = new int[n];
            System.out.print("Enter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        System.out.println(String.format("\nNumber of triplets : %d", countTriplets(arr, k)));
    }
}
