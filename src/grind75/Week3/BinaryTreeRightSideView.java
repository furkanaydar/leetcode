package grind75.Week3;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {
            List<TreeNode> polled = new ArrayList<>();
            while (!q.isEmpty()) {
                polled.add(q.poll());
            }

            res.add(polled.get(polled.size()-1).val);

            for (TreeNode node: polled) {
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        return res;
    }
}
