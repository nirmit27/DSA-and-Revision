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

    #8 : "Intersection in Y Shaped Lists" solution
    Link : https://www.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1

    #9 : "Palindrome Linked List" solution
    Link : https://www.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1

    #10 : "Flattening a Linked List" solution
    Link : https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1
 */

import java.util.Stack;
import java.util.Comparator;
import java.util.PriorityQueue; // Min Heap

public class Operations {
    /* Problem #10 - Flatten a NESTED Linked List */
    public static NestNode flatten(NestNode root) {
        PriorityQueue<NestNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.data));
        NestNode head = null, tail = null, temp = null;

        while (root != null) {
            pq.offer(root);
            root = root.next;
        }

        while (!pq.isEmpty()) {
            temp = pq.poll();

            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.bottom = temp;
                tail = tail.bottom;
            }

            if (temp.bottom != null) {
                pq.offer(temp.bottom);
                temp.bottom = null;
            }
        }
        return head;
    }

    /* Problem #9 - Palindrome Check */
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node fast = head, slow = head;

        // Locate the middle of the linked list
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the latter half of the linked list
        Node revHead = Node.reverseList(slow.next);
        slow.next = null;

        // Compare both halves of the list
        boolean res = Node.isIdentical(head, revHead);

        // Reverse the latter half BACK and link again
        revHead = Node.reverseList(revHead);
        slow.next = revHead;
        return res;
    }

    /* Problem #8 - Intersection Point of two lists */
    public static Node intersectPoint(Node head1, Node head2) {
        Node p1 = head1, p2 = head2;

        if (p1 == null || p2 == null)
            return null;

        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : head2;
            p2 = (p2 != null) ? p2.next : head1;
        }
        return p1;
    }

    /* Problem #7 - Remove cycle */
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

    /* Problem #6 - Find First Node of Cycle */
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
