package grind75.Week1;

import common.TreeNode;

public class LowestCommonAncestorOfBST {

    // first solution but not logN
    static TreeNode dfs(TreeNode root, int s, int e) {
        if (root == null) {
            return null;
        }

        if (root.val == s || root.val == e) {
            return root;
        }

        TreeNode left = dfs(root.left, s, e);
        TreeNode right = dfs(root.right, s, e);

        if (left != null) {
            if (right != null) {
                return root;
            }

            return left;
        }

        return right;
    }


    // first solution but not logN
    static TreeNode dfs2(TreeNode root, int s, int e) {
        if (root == null) {
            return null;
        }

        if (root.val < s && root.val < e) {
            return dfs(root.right, s, e);
        }

        if (root.val > s && root.val > e) {
            return dfs(root.left, s, e);
        }

        return root;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs2(root, p.val, q.val);
    }

    public static TreeNode case1() {
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        return lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
    }

    public static TreeNode case2() {
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4, new TreeNode(3), new TreeNode(5))), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        return lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
    }

    public static TreeNode case3() {
        TreeNode root = new TreeNode(2, new TreeNode(1), null);
        return lowestCommonAncestor(root, new TreeNode(2), new TreeNode(1));
    }

    public static void main(String[] args) {
        System.out.println(case1().val);
        System.out.println(case2().val);
        System.out.println(case3().val);
    }
}
