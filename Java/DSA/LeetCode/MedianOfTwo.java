package LeetCode;
/* 
LeetCode problem #4 solution
Link : https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

import java.util.Scanner;

public class MedianOfTwo {
    public static double median(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length)
            return median(nums2, nums1);

        int n = nums1.length, m = nums2.length;
        int low = 0, high = n;

        int m1 = low + (high - low) / 2;
        int m2 = (n + m + 1) / 2 - m1;

        int l1 = (m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1]);
        int r1 = (m1 == n ? Integer.MAX_VALUE : nums1[m1]);

        int l2 = (m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        int r2 = (m2 == m ? Integer.MAX_VALUE : nums2[m2]);

        while (low <= high) {
            m1 = low + (high - low) / 2;
            m2 = (n + m + 1) / 2 - m1;

            l1 = (m1 == 0 ? Integer.MIN_VALUE : nums1[m1 - 1]);
            r1 = (m1 == n ? Integer.MAX_VALUE : nums1[m1]);

            l2 = (m2 == 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
            r2 = (m2 == m ? Integer.MAX_VALUE : nums2[m2]);

            if (l1 <= r2 && l2 <= r1)
                if ((n + m) % 2 == 0)
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                else
                    return Math.max(l1, l2);

            if (l1 > r2)
                high = m1 - 1;
            else
                low = m1 + 1;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr1, arr2;
        int size1, size2;

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of 1st array : ");
            size1 = sc.nextInt();
            arr1 = new int[size1];

            System.out.print("\nEnter the elements of 1st array : ");
            for (int i = 0; i < size1; i++)
                arr1[i] = sc.nextInt();

            System.out.print("\nEnter the size of 2nd array : ");
            size2 = sc.nextInt();
            arr2 = new int[size2];

            System.out.print("\nEnter the elements of 2nd array : ");
            for (int i = 0; i < size2; i++)
                arr2[i] = sc.nextInt();
        }
        System.out.println(String.format("\nMedian = %.2f", median(arr1, arr2)));
    }
}
