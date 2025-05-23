package GfG.LinkedLists;
/* Sample implementation of a singly-linked list node */

public class Node {
    int data;
    Node next;

    // Constructor
    Node(int value) {
        this.data = value;
        this.next = null;
    }

    /* Utility Methods */

    // Check identical linked lists
    public static boolean isIdentical(Node h1, Node h2) {
        while (h1 != null && h2 != null) {
            if (h1.data != h2.data)
                return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    // Reverse a complete linked list
    public static Node reverseList(Node node) {
        Node prev = null, next = null, curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Reverse a linked list till `k` nodes
    public static Node reverseListK(Node node, int k) {
        Node prev = null, next = null, curr = node;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            count++;
        }
        return prev;
    }

    // Count the number of nodes
    public static int countNodes(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Trim leading zeros from the linked list
    public static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0)
            head = head.next;
        return head;
    }
}