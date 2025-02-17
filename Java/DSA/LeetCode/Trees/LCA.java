package LeetCode.Trees;
/*
LeetCode problem #236 solution
Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // TODO: TBD
    }
}
