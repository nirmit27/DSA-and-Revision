package GfG.Greedy;
/* 
GfG problem - "Activity Selection" solution
Link : https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1
 */

import java.util.PriorityQueue;

public class ActivitySelect {
    public static int activitySelect(int[] start, int[] finish) {
        int[] act;
        int n = start.length, ft = -1, res = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < n; i++)
            minHeap.offer(new int[] { finish[i], start[i] });

        while (!minHeap.isEmpty()) {
            act = minHeap.poll();

            if (ft < act[1]) {
                ft = act[0];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
