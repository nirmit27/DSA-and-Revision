package GfG.Trees;
/* 
   --- GfG Problems ---
   #1 : "Level order traversal" solution
   Link : https://www.geeksforgeeks.org/problems/level-order-traversal/1

   // TODO
*/

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class Traversals {
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
