package GfG.TwoPointers;
/* 
GfG problems - "Count pairs with given sum" and "Pair with given sum in a sorted array" solution
    Link #1 : https://www.geeksforgeeks.org/problems/count-pairs-with-given-sum--150253/1
    Link #2 : https://www.geeksforgeeks.org/problems/pair-with-given-sum-in-a-sorted-array4940/1
 */

import java.util.Arrays;

public class TwoSum {
    public static int twoPointerApproach(int[] arr, int target) {
        Arrays.sort(arr); // omit this line for problem #2
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
}
