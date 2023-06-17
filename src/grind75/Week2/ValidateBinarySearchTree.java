package grind75.Week2;

import common.TreeNode;

public class ValidateBinarySearchTree {
    public static boolean rec(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.val == Integer.MIN_VALUE) {
            return root.left == null && rec(root.right, root.val+1, max);
        }

        if (root.val == Integer.MAX_VALUE) {
            return root.right == null && rec(root.left, min, root.val-1);
        }

        return root.val>min &&
                root.val<max &&
                rec(root.left, min, root.val) &&
                rec(root.right, root.val, max);
    }

    public static boolean isValidBST(TreeNode root) {
        return rec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(2147483647, new TreeNode(2147483647), null);
        TreeNode t1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode t2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST(t3));
    }
}
