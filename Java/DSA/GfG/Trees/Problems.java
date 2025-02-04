package GfG.Trees;
/* 
   --- GfG Problems ---
   #1 : "Level order traversal" solution
   Link : https://www.geeksforgeeks.org/problems/level-order-traversal/1

   #2 : "Height of Binary Tree" solution
   Link : https://www.geeksforgeeks.org/problems/height-of-binary-tree/1

   #3 : "Diameter of a Binary Tree" solution
   Link : https://www.geeksforgeeks.org/problems/diameter-of-binary-tree/1

   // TODO
*/

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Problems {
    public int dia = 0;

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
