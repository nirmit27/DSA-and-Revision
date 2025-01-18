package GfG.LinkedLists;
/* 
GfG problem - "Reverse a linked list" solution
Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1
 */

import java.util.Stack;

public class ReverseList {
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
