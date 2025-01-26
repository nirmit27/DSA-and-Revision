package GfG.LinkedLists;
/* Sample implementation of a doubly-linked list node */

public class DLLNode {
    int key, value;
    DLLNode prev, next;

    DLLNode(int k, int v) {
        this.key = k;
        this.value = v;
        this.prev = null;
        this.next = null;
    }
}