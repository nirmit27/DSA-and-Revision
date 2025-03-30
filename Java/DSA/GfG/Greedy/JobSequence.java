package GfG.Greedy;
/* 
GfG problem - "Job Sequencing Problem" solution
Link : https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 */

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class JobSequence {
    public ArrayList<Integer> jobSequence(int[] deadline, int[] profit) {
        int n = profit.length;
        ArrayList<int[]> jobs = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>(Arrays.asList(0, 0));
        
        for (int i = 0; i < n; i++)
            jobs.add(new int[]{deadline[i], profit[i]});
            
        jobs.sort(Comparator.comparingInt(a -> a[0]));
        
        for (int[] job : jobs) {
            if (job[0] > pq.size())
                pq.offer(job[1]);
            else if (!pq.isEmpty() && pq.peek() < job[1]) {
                pq.poll();
                pq.offer(job[1]);
            }
        }
        
        while (!pq.isEmpty()) {
            ans.set(0, ans.get(0) + 1);
            ans.set(1, ans.get(1) + pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
