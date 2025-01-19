package GfG.LinkedLists;
/* 
    --- GfG Problems ---
    #1 : "Reverse a linked list" solution
    Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1    

    #2 : "Rotate a Linked List" solution
    Link : https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1
 */

import java.util.Stack;

public class Operations {
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
