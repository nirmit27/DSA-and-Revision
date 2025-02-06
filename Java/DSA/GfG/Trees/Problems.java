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
*/

import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class Problems {
    public int dia = 0; // Problem #3
    private static int preIndex = 0; // Problem #5

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
