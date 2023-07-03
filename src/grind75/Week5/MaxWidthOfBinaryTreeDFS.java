package grind75.Week5;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class MaxWidthOfBinaryTreeDFS {

    Map<Integer, Integer> levelToLeftMostIndex = new HashMap<>();

    public int dfs(TreeNode root, int depth, int index) {
        if (root == null) {
            return 0;
        }

        if (!levelToLeftMostIndex.containsKey(depth)) {
            levelToLeftMostIndex.put(depth, index);
        }

        int curLevelRes = index-levelToLeftMostIndex.get(depth)+1;
        int lr = dfs(root.left, depth+1, index*2+1);
        int rr = dfs(root.right, depth+1, index*2+2);
        return Math.max(curLevelRes, Math.max(lr, rr));
    }

    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 0);
    }

    public static void main(String[] args) {
        TreeNode in2 = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)));
        System.out.println(new MaxWidthOfBinaryTreeDFS().widthOfBinaryTree(in2));
    }
}