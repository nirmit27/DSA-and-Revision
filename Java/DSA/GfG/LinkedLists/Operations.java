package GfG.LinkedLists;
/* 
    --- GfG Problems ---
    #1 : "Reverse a linked list" solution
    Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list/1    

    #2 : "Rotate a Linked List" solution
    Link : https://www.geeksforgeeks.org/problems/rotate-a-linked-list/1

    #3 : "Merge two sorted linked lists" solution
    Link : https://www.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1

    #4 : "Linked List Group Reverse" solution
    Link : https://www.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

    #5 : "Add Number Linked Lists" solution
    Link : https://www.geeksforgeeks.org/problems/add-two-numbers-represented-by-linked-lists/1

    #6 : "Find the first node of loop in linked list" solution
    Link : https://www.geeksforgeeks.org/problems/find-the-first-node-of-loop-in-linked-list--170645/1

    #7 : "Remove loop in Linked List" solution
    Link : https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 */

import java.util.Stack;

public class Operations {
    /* Problem #7 - Remove Loop */
    public static void removeLoop(Node head) {
        Node slow = head, fast = head;

        // Step #1 : Detecting the cycle
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast)
                break;
        }

        // Step #2 : Determine loop node
        if (slow == fast) {
            slow = head;

            /* Step #3 : Remove loop */
            // Case 1 : Slow at HEAD
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            } else {
                // Case 2 : Both at HEAD
                while (fast.next != slow)
                    fast = fast.next;
            }
            fast.next = null;
        }
    }
    
    /* Problem #6 - Add Number Lists */
    public static Node findFirstNodeLoop(Node head) {
        Node slow = head, fast = head;

        // Step #1 : Detect the cycle - Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Step #2 : Determine the first node of the cycle
            if (slow == fast) {
                slow = head;

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    /* Problem #5 - Add Number Lists */
    static Node addTwoLists(Node num1, Node num2) {
        num1 = Node.trimLeadingZeros(num1);
        num2 = Node.trimLeadingZeros(num2);

        int carry = 0;
        int l1 = Node.countNodes(num1), l2 = Node.countNodes(num2);
        if (l1 < l2)
            return addTwoLists(num2, num1);

        num1 = Node.reverseList(num1);
        num2 = Node.reverseList(num2);
        Node ans = num1;

        while (num2 != null || carry != 0) {
            num1.data += carry;

            if (num2 != null) {
                num1.data += num2.data;
                num2 = num2.next;
            }
            carry = num1.data / 10;
            num1.data = num1.data % 10;

            if (num1.next == null && carry != 0)
                num1.next = new Node(0);

            num1 = num1.next;
        }
        return Node.reverseList(ans);
    }

    /* Problem #4 - `K`-group Reversal */
    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1)
            return head;

        Node temp = head, tHead = null;
        int count = 0;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        // New head for current `k` group
        tHead = Node.reverseListK(head, k);

        // Original head -> Tail of new `k` group
        head.next = reverseKGroup(temp, k);

        return tHead;
    }

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
