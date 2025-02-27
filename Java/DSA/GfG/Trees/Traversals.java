package GfG.Trees;
/* 
   --- GfG Problems ---
   #1 : "Level order traversal" solution
   Link : https://www.geeksforgeeks.org/problems/level-order-traversal/1

   #2 : "Tree Boundary Traversal" solution
   Link : https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1

   #3 : "Vertical Tree Traversal" solution
   Link : https://www.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
*/

import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Traversals {
    /* Problem #3 - Vertical traversal */
    private static int minHd;
    
    private static void dfs(Node root, HashMap<Integer, ArrayList<Integer>> mp, int hd) {
        if (root == null)
            return;
            
        if (!mp.containsKey(hd))
            mp.put(hd, new ArrayList<>());
            
        mp.get(hd).add(root.data);
        minHd = Math.min(minHd, hd);
        
        dfs(root.left, mp, hd - 1);
        dfs(root.right, mp, hd + 1);
    }
    
    public static ArrayList<ArrayList<Integer>> verticalOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> mp = new HashMap<>();

        int hd = 0;
        minHd = 0;

        dfs(root, mp, hd);
        hd = minHd;

        // Traversing from MIN. to MAX. horizontal distance
        while (mp.containsKey(hd)) {
            res.add(mp.get(hd));
            hd++;
        }
        return res;
    }
    

    /* Problem #2 - Boundary traversal */
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
