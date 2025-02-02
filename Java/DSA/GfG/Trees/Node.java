package GfG.Trees;
/* Sample implementation of a Binary Tree node. */

public class Node {
    public int data;
    public Node left, right;

    public Node() {
        data = 0;
        left = right = null;
    }

    public Node(int item) {
        data = item;
        left = right = null;
    }
}
