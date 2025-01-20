package GfG.LinkedLists;
/* 
    --- GfG Problems ---
    #1 : "Reverse a linked list" solution
    Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1    

    #2 : "Rotate a Linked List" solution
    Link : https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1

    #3 : "Merge two sorted linked lists" solution
    Link : https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
 */

import java.util.Stack;

public class Operations {
    /* Problem #3 - Sorted Merge */
    Node sortedMerge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null || head2 != null)
            current.next = head1 == null ? head2 : head1;
        return dummy.next;
    }

    /* Problem #2 - Rotation */
    public Node rotateList(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        Node temp = head;
        int length = 1;

        // Determine the length
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Locate new position of HEAD
        k %= length;
        temp.next = head;

        while (k > 0) {
            temp = temp.next;
            k--;
        }

        // Perform rotation
        head = temp.next;
        temp.next = null;
        return head;
    }

    /* Problem #1 - Reversal */
    // ITERATIVE Approach
    public Node reverseListI(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    // RECURSIVE Approach
    public Node reverseListR(Node head) {
        if (head == null || head.next == null)
            return head;

        Node rest = reverseListR(head.next);

        head.next.next = head;
        head.next = null;

        return rest;
    }

    // STACK Approach
    public Node reverseListS(Node head) {
        Node temp = head;
        Stack<Node> stack = new Stack<>();

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        if (!stack.isEmpty()) {
            head = stack.pop();
            temp = head;

            while (!stack.isEmpty()) {
                temp.next = stack.pop();
                temp = temp.next;
            }
            temp.next = null;
        }
        return head;
    }
}
