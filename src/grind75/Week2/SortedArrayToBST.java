package grind75.Week2;


import common.TreeNode;

public class SortedArrayToBST {

    public static TreeNode create(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int m=l+(r-l)/2;
        return new TreeNode(nums[m], create(nums, l, m-1), create(nums, m+1, r));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return create(nums, 0, nums.length-1);
    }
}
