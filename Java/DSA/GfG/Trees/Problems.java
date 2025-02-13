package GfG.Trees;
/* 
   --- GfG Problems ---
   #1 : "Level order traversal" solution
   Link : https://www.geeksforgeeks.org/problems/level-order-traversal/1

   #2 : "Height of Binary Tree" solution
   Link : https://www.geeksforgeeks.org/problems/height-of-binary-tree/1

   #3 : "Diameter of a Binary Tree" solution
   Link : https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1

   #4 : "Mirror Tree" solution
   Link : https://www.geeksforgeeks.org/problems/mirror-tree/1

   #5 : "Construct Tree from Inorder & Preorder" solution
   Link : https://www.geeksforgeeks.org/problems/construct-tree-1/1

   #6 : "Tree Boundary Traversal" solution
   Link : https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

   #7 : "Maximum path sum from any node" solution
   Link : https://www.geeksforgeeks.org/problems/maximum-path-sum-from-any-node/1

   #8 : "K Sum Paths" solution
   Link : https://www.geeksforgeeks.org/problems/k-sum-paths/1

   #9 : "Fixing Two nodes of a BST" solution
   Link : https://www.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1

   #10 : "Pair Sum in BST" solution
   Link : https://www.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
*/

import java.util.Map;
import java.util.Set;
import java.util.Queue;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.LinkedList;

public class Problems {
    public int dia = 0; // Problem #3
    private static int preIndex = 0; // Problem #5
    private int maxSum; // Problem #7

    /* Problem #9 */
    private Node first;
    private Node mid;
    private Node last;
    private Node prev;

    /* Problem #10 - Pair Sum */
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

    /* Problem #9 - Fix the BST */
    private void swap(Node a, Node b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    private void solve2(Node root) {
        if (root == null)
            return;

        // Left sub-tree ...
        solve2(root.left);

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
        solve2(root.right);
    }

    public void correctBST(Node root) {
        first = null;
        mid = null;
        last = null;
        prev = null;

        solve2(root);

        // Case 1 : Non-adjacent positions
        if (first != null && last != null)
            swap(first, last);

        // Case 2 : Adjacent positions
        else if (first != null && mid != null)
            swap(first, mid);
    }

    /* Problem #8 - K-Sum paths */
    private int solve(Node root, Map<Integer, Integer> prefix, int current, int k) {
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
        count += solve(root.left, prefix, current, k);
        count += solve(root.right, prefix, current, k);

        // Step 3 : BACKTRACK - Decrement the frequency of current sum
        prefix.put(current, prefix.getOrDefault(current, 0) - 1);
        return count;
    }

    public int kSumPaths(Node root, int k) {
        Map<Integer, Integer> prefix = new HashMap<>();
        return solve(root, prefix, 0, k);
    }

    /* Problem #7 - Maximum path sum */
    private int solve(Node node) {
        if (node == null)
            return 0;

        int lValue = Math.max(0, solve(node.left));
        int rValue = Math.max(0, solve(node.right));

        maxSum = Math.max(maxSum, node.data + lValue + rValue);
        return node.data + Math.max(lValue, rValue);
    }

    public int findMaxSum(Node node) {
        maxSum = Integer.MIN_VALUE;
        solve(node);

        return maxSum;
    }

    /* Problem #6 - Boundary traversal */
    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private void collectRight(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;

        Node curr = root;
        ArrayList<Integer> rev = new ArrayList<>();

        while (!isLeaf(curr)) {
            rev.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        for (int i = rev.size() - 1; i >= 0; i--)
            res.add(rev.get(i));
    }

    private void collectLeaves(Node root, ArrayList<Integer> res) {
        Node curr = root;

        while (curr != null) {

            // CASE : No LEFT child
            if (curr.left == null) {

                // CASE : Leaf Node
                if (curr.right == null)
                    res.add(curr.data);

                curr = curr.right;
            } else {

                // CASE : Find In-order PRE-decessor
                Node prev = curr.left;

                // Find the rightmost child in the left sub-tree
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;

                // CASE : FOUND the Leaf node
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    // CASE : Repeated in-order successor
                    if (prev.left == null)
                        res.add(prev.data);

                    prev.right = null;
                    curr = curr.right;
                }
            }
        }

    }

    private void collectLeft(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;

        Node curr = root;

        while (!isLeaf(curr)) {
            res.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        if (!isLeaf(root))
            res.add(root.data);

        collectLeft(root.left, res);
        collectLeaves(root, res);
        collectRight(root.right, res);

        return res;
    }

    /* Problem #5 - Construct the tree from In-order and Pre-order traversals */
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

    /* Problem #4 - Invert the tree */
    public void invert(Node root) {
        if (root == null)
            return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    private int dfs(Node root) {
        if (root == null)
            return 0;

        int lh = dfs(root.left);
        int rh = dfs(root.right);

        dia = Math.max(dia, lh + rh);
        return 1 + Math.max(lh, rh);
    }

    /* Problem #3 - Diameter */
    public int diameter(Node root) {
        if (root == null)
            return 0;

        dfs(root);
        return dia;
    }

    /* Problem #2 - Height */
    public int height(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    /* Problem #1 - Level-order traversal */
    public static ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<Node> q = new LinkedList<>();
        int size = 0, level = 0;
        Node current = null;

        q.add(root);
        while (!q.isEmpty()) {
            size = q.size();
            res.add(new ArrayList<>());

            while (size-- > 0) {
                current = q.poll();
                res.get(level).add(current.data);

                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
            }
            level++;
        }
        return res;
    }
}
