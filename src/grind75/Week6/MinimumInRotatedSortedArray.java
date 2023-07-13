package grind75.Week6;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        int mid=0;

        while (l<r) {
            mid=l+(r-l)/2;
            if (nums[mid] >= nums[l]) {
                if (nums[r] < nums[mid] && nums[mid]>nums[mid+1]) {
                    break;
                }

                l=mid+1;
            } else {
                r=mid;
            }
        }

        mid=l+(r-l)/2;
        return Math.min(nums[mid], nums[(mid+1)%(nums.length)]);
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray q = new MinimumInRotatedSortedArray();
        //q.findMin(new int[] {11,13,15,17});
        q.findMin(new int[] {3,4,5,1,2});

    }
}
