package grind75.Week2;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curRes = new ArrayList<>();
            Queue<TreeNode> nq = new LinkedList<>();
            while (!q.isEmpty()) {
                TreeNode polled = q.poll();
                curRes.add(polled.val);

                if (polled.left != null) {
                    nq.add(polled.left);
                }

                if (polled.right != null) {
                    nq.add(polled.right);
                }
            }

            res.add(curRes);
            q.addAll(nq);
        }

        return res;
    }


}