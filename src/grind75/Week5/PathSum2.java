package grind75.Week5;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

    public void dfs(TreeNode cur, List<Integer> path, int curSum, int targetSum, List<List<Integer>> res) {
        if (curSum == targetSum && cur.left == null && cur.right == null) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (cur.left != null) {
            path.add(cur.left.val);
            dfs(cur.left, path, curSum+cur.left.val, targetSum, res);
            path.remove(path.size()-1);
        }

        if (cur.right != null) {
            path.add(cur.right.val);
            dfs(cur.right, path, curSum+cur.right.val, targetSum, res);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return List.of();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, path, root.val, targetSum, res);
        return res;
    }

    public static void main(String[] args) {
        PathSum2 ps = new PathSum2();
        TreeNode tn = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        TreeNode tn2 = new TreeNode(-2, null, new TreeNode(-3));
        TreeNode tn3 = new TreeNode(1, new TreeNode(-2, new TreeNode(1, new TreeNode(-1), null), new TreeNode(3)), new TreeNode(-3, new TreeNode(-2), null));

        List<List<Integer>> res = ps.pathSum(tn3, -1);
        int x = 5;
    }
}
