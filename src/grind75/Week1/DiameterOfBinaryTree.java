package grind75.Week1;

import common.TreeNode;

public class DiameterOfBinaryTree {

    int result = Integer.MIN_VALUE;

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        int s = 0;

        if (root.left != null) {
            s+=l;
        }

        if (root.right != null) {
            s+=r;
        }

        result = Math.max(result, s);
        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

}
