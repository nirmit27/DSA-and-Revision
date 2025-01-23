package LeetCode.LinkedLists;
/*
LeetCode problem #138 solution
Link : https://leetcode.com/problems/copy-list-with-random-pointer/
 */

public class CopyWithRandom {
    public Node copyRandomList(Node head) {
        if (head == null)
            return head;

        // Step #1 - Clone in-place
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // Step #2 - Set the random pointers in the clones
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }

        // Step #3 - Unlink the clones from the original nodes
        Node result = head.next;
        Node res = result;
        curr = head;

        while (curr != null) {
            curr.next = curr.next.next;
            if (res.next != null)
                res.next = res.next.next;
            curr = curr.next;
            res = res.next;
        }

        return result;
    }
}
