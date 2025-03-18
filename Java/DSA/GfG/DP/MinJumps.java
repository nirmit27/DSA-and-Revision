package GfG.DP;
/* 
GfG problem - "Minimum Jumps" solution
Link : https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1
 */

public class MinJumps {
    public static int minJumps(int[] arr) {
        int maxReach = 0, currReach = 0, jumps = 0, n = arr.length;

        // Edge case : Cannot perform a jump from the starting position
        if (arr[0] == 0)
            return -1;

        for (int i = 0; i < n; i++) {
            maxReach = Math.max(maxReach, i + arr[i]);

            // Case #1 : If we can jump all the way to the end or beyond [GREEDY]
            if (maxReach >= (n - 1))
                return jumps + 1; // adding 1 to consider the current jump to be made

            // Case #2 : Updating the current reach position
            if (i == currReach) {
                if (maxReach == i) // cannot move any further from current position
                    return -1;
                else {
                    jumps++;
                    currReach = maxReach;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
