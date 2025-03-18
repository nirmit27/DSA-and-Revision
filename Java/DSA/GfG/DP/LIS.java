package GfG.DP;
/* 
GfG problem - "Longest Increasing Subsequence" solution
Link : https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
 */

import java.util.ArrayList;
import java.util.Collections;

public class LIS {
    public static int lis(int arr[]) {
        ArrayList<Integer> lis = new ArrayList<>();
        int n = arr.length, low;

        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (lis.get(lis.size() - 1) < arr[i])
                lis.add(arr[i]);
            else {
                low = Collections.binarySearch(lis, arr[i]);
                low = (low < 0) ? -(low + 1) : low;

                lis.set(low, arr[i]);
            }
        }
        return lis.size();
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
