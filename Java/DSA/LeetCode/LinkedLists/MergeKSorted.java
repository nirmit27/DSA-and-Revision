package LeetCode.LinkedLists;
/*
LeetCode problem #23 solution
Link : https://leetcode.com/problems/merge-k-sorted-lists/
 */

import java.util.PriorityQueue;

public class MergeKSorted {
    public Node mergeKLists(Node[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (Node head : lists) {
            if (head != null)
                pq.offer(head);
        }

        Node dummy = new Node(-1);
        Node curr = dummy, temp = null;

        while (!pq.isEmpty()) {
            temp = pq.poll();
            curr.next = temp;
            curr = temp;

            if (temp.next != null)
                pq.offer(temp.next);
        }
        return dummy.next;
    }
}
