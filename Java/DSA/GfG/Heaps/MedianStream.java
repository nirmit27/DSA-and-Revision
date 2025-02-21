package GfG.Heaps;
/*
GfG problem - "k largest elements" solution
Link : https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MedianStream {
    public ArrayList<Double> getMedian(int[] arr) {
        int temp;
        double med;

        ArrayList<Double> res = new ArrayList<>();
        PriorityQueue<Integer> lMax = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> rMin = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            lMax.offer(arr[i]);
            temp = lMax.poll();
            rMin.offer(temp);

            if (rMin.size() > lMax.size()) {
                temp = rMin.poll();
                lMax.offer(temp);
            }

            if (lMax.size() != rMin.size())
                med = lMax.peek();
            else
                med = (lMax.peek() + rMin.peek()) / 2.0;

            res.add(med);
        }
        return res;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
