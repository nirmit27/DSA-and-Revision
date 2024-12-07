package Custom.CustomLinkedList;

public class LList {
    private class Node {
        private int val;
        private Node next;

        @SuppressWarnings("unused")
        Node() {
        }

        Node(int value) {
            this.val = value;
        }

        Node(int value, Node node) {
            this.val = value;
            this.next = node;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    LList() {
        this.size = 0;
    }

    LList(int size) {
        this.size = size;
    }

    private Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++)
            node = node.next;

        return node;
    }

    public void traversal() {
        System.out.print(String.format("\nSTATUS :\nSize = %d\nNodes : ", size));

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void reversal() {
        if (size == 1)
            return;

        Node prev = null;
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head = tail;
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null)
            tail = head;

        System.out.println(String.format("\nInserted %d at the BEGINNING.", val));
        size += 1;
    }

    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;

        System.out.println(String.format("\nInserted %d at the END.", val));
        size += 1;
    }

    public void insert(int index, int val) {
        if (index == 0) {
            insertFirst(val);
            return;
        }
        if (index == size - 1) {
            insertLast(val);
            return;
        }
        Node prev = get(index - 1);
        Node node = new Node(val, prev.next);
        prev.next = node;

        System.out.println(String.format("\nInserted node %d at index %d.", val, index));
        size += 1;
    }

    public void deleteFirst() {
        if (size <= 0) {
            System.out.println("\nList is EMPTY.");
            return;
        }
        int value = head.val;
        head = head.next;
        if (head == null)
            tail = null;

        System.out.println(String.format("\nPopped %d from the BEGINNING.", value));
        size -= 1;
    }

    public void deleteLast() {
        if (size <= 0) {
            System.out.println("\nList is EMPTY.");
            return;
        }
        if (size == 1) {
            deleteFirst();
            return;
        }
        Node secondLast = get(size - 2);
        int value = tail.val;
        tail = secondLast;
        tail.next = null;

        System.out.println(String.format("\nPopped %d from the END.", value));
        size -= 1;
    }

    public void delete(int index) {
        if (index == 0) {
            deleteFirst();
            return;
        }
        if (index == size - 1) {
            deleteLast();
            return;
        }
        Node prev = get(index - 1);
        int value = prev.next.val;
        prev.next = prev.next.next;

        System.out.println(String.format("\nPopped %d from index %d.", value, index));
        size -= 1;
    }
}
