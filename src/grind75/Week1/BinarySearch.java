package grind75.Week1;

public class BinarySearch {
    int binarySearch(int[] nums, int l, int r, int target) {
        int mid = l + (r-l)/2;

        if (nums[mid] == target) {
            return mid;
        }

        if (l >= r) {
            return -1;
        }

        if (nums[mid] > target) {
            return binarySearch(nums, l, mid - 1, target);
        }

        return binarySearch(nums, mid, r, target);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }
}
