/* 
LeetCode problem #494 solution
Link : https://leetcode.com/problems/target-sum/
 */

import java.util.Scanner;

public class TargetSum {
    private static int countSubsets(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n][target + 1];
        
        for (int i = 0; i < n; i++)
            dp[i][0] = 1;

        if (arr[0] == 0)
            dp[0][0] = 2;
            
        if (arr[0] != 0 && arr[0] <= target)
            dp[0][arr[0]] = 1;
            
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                int notTaken = dp[i - 1][j];
                int taken = 0;
                
                if (arr[i] <= j)
                    taken = dp[i - 1][j - arr[i]];
                    
                dp[i][j] = taken + notTaken;
            }
        }
        return dp[n - 1][target];
    }
    
    public static int findSolutions(int[] arr, int target) {
        int total = 0;
        for (int i : arr)
            total += i;

        if (total < target || (total - target) % 2 != 0)
            return 0;

        return countSubsets(arr, (total - target) / 2);
    }

    public static void main(String[] args) {
        int n, target, res;
        int[] arr;
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nEnter the size of array : ");
            n = sc.nextInt();
            
            System.out.print("\nEnter the target sum : ");
            target = sc.nextInt();
            
            arr = new int[n];
            System.out.print("\nEnter the elements : ");
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
        }
        res = findSolutions(arr, target);
        System.out.println(String.format("\nNo. of possible expressions : %d", res));
    }
}
