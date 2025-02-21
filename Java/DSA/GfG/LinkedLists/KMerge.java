package GfG.LinkedLists;
/* 
GfG problem - "Merge K sorted linked lists" solution
Link : https://www.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
 */

import java.util.List;
import java.util.PriorityQueue;

public class KMerge {
    public Node mergeKLists(List<Node> arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        Node temp, head = null, tail = null;

        for (Node n : arr)
            pq.offer(n);

        while (!pq.isEmpty()) {
            temp = pq.poll();

            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            if (temp.next != null)
                pq.add(temp.next);
        }
        return head;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
