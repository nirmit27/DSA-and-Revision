package GfG.Greedy;
/* 
GfG problem - "Minimum Platforms" solution
Link : https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */

import java.util.Arrays;

public class MinPlats {
    public static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int j = 0, res = 0, ctr = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            while (j < n && dep[j] < arr[i]) {
                ctr--; // tracking departures
                j++;
            }

            ctr++; // tracking arrivals
            res = Math.max(res, ctr);
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
