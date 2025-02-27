package GfG.Trees;
/* 
   --- GfG Problems ---
   #1 : "Height of Binary Tree" solution
   Link : https://www.geeksforgeeks.org/problems/height-of-binary-tree/1

   #2 : "Diameter of a Binary Tree" solution
   Link : https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1

   #3 : "Mirror Tree" solution
   Link : https://www.geeksforgeeks.org/problems/mirror-tree/1

   #4 : "Construct Tree from Inorder & Preorder" solution
   Link : https://www.geeksforgeeks.org/problems/construct-tree-1/1

   #5 : "Maximum path sum from any node" solution
   Link : https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1

   #6 : "K Sum Paths" solution
   Link : https://www.geeksforgeeks.org/problems/k-sum-paths/1

   #7 : "Fixing Two nodes of a BST" solution
   Link : https://www.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1

   #8 : "Pair Sum in BST" solution
   Link : https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1

   #9 : "Serialize and deserialize a binary tree" solution
   Link : https://www.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1

   #10 : "Symmetric Tree" solution
   Link : https://www.geeksforgeeks.org/problems/symmetric-tree/1

   #11 : "Balanced Tree Check" solution
   Link : https://www.geeksforgeeks.org/problems/check-for-balanced-tree/1
*/

import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class Operations {
    public int dia = 0;
    private int maxSum; 
    private static int preIndex = 0;

    private Node first;
    private Node mid;
    private Node last;
    private Node prev;


    /* Problem #11 - Balance of a BST */
    private int solveP13(Node root) {
        if (root == null)
            return 0;

        int lh = solveP13(root.left);
        int rh = solveP13(root.right);

        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1)
            return -1;

        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(Node root) {
        return solveP13(root) > 0;
    }


    /* Problem #10 - Symmetry of a BST */
    private static boolean solveP12(Node left, Node right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null || left.data != right.data)
            return false;

        return solveP12(left.left, right.right) && solveP12(left.right, right.left);
    }

    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true;

        return solveP12(root.left, root.right);
    }


    /* Problem #9 - Serialization and Deserialization of a BST */
    private Node createNode(int index, ArrayList<Integer> data) {
        if (index >= data.size() || data.get(index) == null)
            return null;
        return new Node(data.get(index));
    }

    public ArrayList<Integer> serialize(Node root) {
        int size = 0;
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        q.add(root);
        res.add(root.data);

        while (!q.isEmpty()) {
            size = q.size();

            while (size-- > 0) {
                Node curr = q.poll();
                Node left = curr.left;
                Node right = curr.right;

                res.add(left != null ? left.data : null);
                if (left != null)
                    q.add(left);

                res.add(right != null ? right.data : null);
                if (right != null)
                    q.add(right);
            }
        }
        return res;
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        int size = 0, index = 1;
        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        while (!q.isEmpty()) {
            size = q.size();

            while (size-- > 0) {
                Node current = q.poll();
                Node left = createNode(index++, arr);
                Node right = createNode(index++, arr);

                current.left = left;
                current.right = right;

                if (left != null)
                    q.add(left);
                if (right != null)
                    q.add(right);
            }
        }
        return root;
    }


    /* Problem #8 - Pair Sum */
    private boolean dfs(Node root, Set<Integer> set, int target) {
        if (root == null)
            return false;

        if (set.contains(target - root.data))
            return true;

        set.add(root.data);

        return dfs(root.left, set, target) || dfs(root.right, set, target);
    }

    public boolean findTarget(Node root, int target) {
        if (root == null)
            return false;

        Set<Integer> set = new HashSet<>();
        return dfs(root, set, target);
    }


    /* Problem #7 - Fix the BST */
    private void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    private void solveP11(Node root) {
        if (root == null)
            return;

        // Left sub-tree ...
        solveP11(root.left);

        // Check for violation ...
        if (prev != null && prev.data > root.data) {
            if (first == null) { // Case 1
                first = prev;
                mid = root;
            } else // Case 2
                last = root;
        }
        prev = root;

        // Right sub-tree ...
        solveP11(root.right);
    }

    public void correctBST(Node root) {
        first = null;
        mid = null;
        last = null;
        prev = null;

        solveP11(root);

        // Case 1 : Non-adjacent positions
        if (first != null && last != null)
            swap(first, last);

        // Case 2 : Adjacent positions
        else if (first != null && mid != null)
            swap(first, mid);
    }


    /* Problem #6 - K-Sum paths */
    private int solveP8(Node root, Map<Integer, Integer> prefix, int current, int k) {
        if (root == null)
            return 0;

        int count = 0;
        current += root.data;

        if (current == k)
            count += 1;
        count += prefix.getOrDefault(current - k, 0);

        // Step 1 : Include the CURRENT PATH with +1 in frequency
        prefix.put(current, prefix.getOrDefault(current, 0) + 1);

        // Step 2 : Explore the children of the node
        count += solveP8(root.left, prefix, current, k);
        count += solveP8(root.right, prefix, current, k);

        // Step 3 : BACKTRACK - Decrement the frequency of current sum
        prefix.put(current, prefix.getOrDefault(current, 0) - 1);
        return count;
    }

    public int kSumPaths(Node root, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        return solveP8(root, prefix, 0, k);
    }


    /* Problem #5 - Maximum path sum */
    private int solveP7(Node node) {
        if (node == null)
            return 0;

        int lValue = Math.max(0, solveP7(node.left));
        int rValue = Math.max(0, solveP7(node.right));

        maxSum = Math.max(maxSum, node.data + lValue + rValue);
        return node.data + Math.max(lValue, rValue);
    }

    public int findMaxSum(Node node) {
        maxSum = Integer.MIN_VALUE;
        solveP7(node);

        return maxSum;
    }


    /* Problem #4 - Construct the tree from In-order and Pre-order traversals */
    private static Node constructPI(Map<Integer, Integer> indices, int[] pre, int left, int right) {
        // BASE CASE: In-order array exhausted
        if (left > right)
            return null;

        int rootVal = pre[preIndex];
        Node root = new Node(rootVal);
        int ii = indices.get(rootVal);

        preIndex++;
        root.left = constructPI(indices, pre, left, ii - 1);
        root.right = constructPI(indices, pre, ii + 1, right);

        return root;
    }

    public static Node buildTree(int inorder[], int preorder[]) {
        preIndex = 0;
        Map<Integer, Integer> indices = new HashMap<>();

        // Storing the in-order indices
        for (int i = 0; i < inorder.length; i++)
            indices.put(inorder[i], i);

        return constructPI(indices, preorder, 0, inorder.length - 1);
    }


    /* Problem #3 - Invert the tree */
    public void invert(Node root) {
        if (root == null)
            return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }


    /* Problem #2 - Diameter */
    private int dfs(Node root) {
        if (root == null)
            return 0;

        int lh = dfs(root.left);
        int rh = dfs(root.right);

        dia = Math.max(dia, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    public int diameter(Node root) {
        if (root == null)
            return 0;

        dfs(root);
        return dia;
    }


    /* Problem #1 - Height */
    public int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
