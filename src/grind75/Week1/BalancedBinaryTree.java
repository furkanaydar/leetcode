package grind75.Week1;

import common.TreeNode;

public class BalancedBinaryTree {

    boolean res = true;

    int heightOfNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lh = heightOfNode(root.left);
        int rh = heightOfNode(root.right);

        int abs = Math.abs(lh - rh);
        if (abs > 1) {
            res = false;
        }

        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        heightOfNode(root);
        return res;
    }

    public TreeNode case1() {
        return new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
    }

    public TreeNode case2() {
        return new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
    }

    public TreeNode case3() {
        return new TreeNode(1);
    }

    public TreeNode case4() {
        return new TreeNode(1, new TreeNode(2), null);
    }
}
