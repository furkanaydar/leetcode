package grind75.Week3;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestInBST {

    public static void rec(TreeNode root, List<Integer> l) {
        if (root == null) {
            return;
        }

        rec(root.left, l);
        l.add(root.val);
        rec(root.right, l);
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        rec(root, l);
        return l.get(k-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left=new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4));
        root.right=new TreeNode(6);
        System.out.println(kthSmallest(root, 3));
    }
}
