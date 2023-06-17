package grind75.Week2;

import common.TreeNode;

public class SymmetricTree {

    public boolean c(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return l == null && r == null;
        }

        return l.val == r.val && c(l.right, r.left) && c(l.left, r.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return c(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));
    }
}
