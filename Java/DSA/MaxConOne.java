/* 
LeetCode problem #1004 solution
Link : https://leetcode.com/problems/max-consecutive-ones-iii/
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class MaxConOne {
    public static int solution(List<Integer> arr, int k) {
        int flips = k;
        int left = 0;
        int ans = Integer.MIN_VALUE;

        for (int right = 0; right < arr.size(); right++) {
            if (arr.get(right) == 0)
                flips--;
            while (flips < 0) {
                if (arr.get(left) == 0)
                    flips++;
                left++;
            }
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        int n, k, res;
        List<Integer> arr = new ArrayList<>();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the number of elements : ");
            n = sc.nextInt();
            System.out.print("\nEnter the number of flips : ");
            k = sc.nextInt();
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                arr.add(x);
            }
        }
        res = solution(arr, k); // 1 1 1 0 0 0 1 1 1 1 0 , 2
        System.out.println(String.format("\nMaximum Consecutive 1's after %d flips : %d", k, res));
    }
}