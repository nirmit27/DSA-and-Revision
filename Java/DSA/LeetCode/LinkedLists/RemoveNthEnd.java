package LeetCode.LinkedLists;
/*
LeetCode problem #19 solution
Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthEnd {
    public Node removeNthFromEnd(Node head, int n) {
        Node fast = head, slow = head;

        for (int i = 0; i < n; i++)
            fast = fast.next;
        if (fast == null)
            return head.next;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
