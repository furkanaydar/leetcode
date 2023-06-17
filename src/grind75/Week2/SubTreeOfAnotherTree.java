package grind75.Week2;

import common.TreeNode;

public class SubTreeOfAnotherTree {

    public boolean dfs(TreeNode root, TreeNode subRoot, boolean exactMatch) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val == subRoot.val &&
                dfs(root.left, subRoot.left, true) &&
                dfs(root.right, subRoot.right, true)) {
            return true;
        }

        return !exactMatch && (dfs(root.left, subRoot, false) || dfs(root.right, subRoot, false));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot, false);
    }
}
