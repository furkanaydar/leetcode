package grind75.Week5;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    class IndexedTreeNode {
        int index;
        TreeNode node;

        public IndexedTreeNode(TreeNode n, int i) {
            this.node = n;
            this.index = i;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        Queue<IndexedTreeNode> q = new LinkedList<>();
        q.add(new IndexedTreeNode(root, 0));
        int res = 1;

        while (!q.isEmpty()) {
            int fi=-1, li=-1, curSize=q.size();

            for (int i=0; i<curSize && !q.isEmpty(); i++) {
                IndexedTreeNode polled = q.poll();

                if (fi == -1) {
                    fi=polled.index;
                } else {
                    li=polled.index;
                }

                if (polled.node.left != null) {
                    q.add(new IndexedTreeNode(polled.node.left, polled.index*2+1));
                }

                if (polled.node.right != null) {
                    q.add(new IndexedTreeNode(polled.node.right, polled.index*2+2));
                }
            }

            if (li != -1) {
                res = Math.max(res, li-fi+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        MaxWidthOfBinaryTree mw = new MaxWidthOfBinaryTree();
        TreeNode in = new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)));
        TreeNode in2 = new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)));
        mw.widthOfBinaryTree(in);
    }
}
