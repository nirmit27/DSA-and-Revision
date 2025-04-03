package GfG.Greedy;
/* 
GfG problem - "Gas Station" solution
Link : https://www.geeksforgeeks.org/problems/circular-tour-1587115620/1
 */

public class GasStation {
    public int startStation(int[] gas, int[] cost) {
        int total = 0, current = 0, idx = 0, n = gas.length;

        for (int i = 0; i < n; i++) {
            current += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (current < 0) {
                current = 0;
                idx = i + 1;
            }
        }
        return total < 0 ? -1 : idx;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
