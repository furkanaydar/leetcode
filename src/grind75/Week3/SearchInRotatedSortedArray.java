package grind75.Week3;

public class SearchInRotatedSortedArray {

    public static int search(int[] nums, int target) {
        int mid, l=0, r=nums.length-1;

        while (l<r) {
            mid = l+(r-l)/2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid] && nums[mid] <= nums[r]) {
                if (nums[mid] > target) {
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            } else if (nums[r] <= nums[l] && nums[l] <= nums[mid]){
                if (nums[mid] < target || target <= nums[r]) {
                    l=mid+1;
                } else {
                    r=mid-1;
                }
            } else if (nums[mid] <= nums[r] && nums[r] <= nums[l]) {
                if (nums[mid] > target || nums[r] < target) {
                    r=mid-1;
                } else {
                    l=mid+1;
                }
            }
        }


        return l==r && nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] in = new int[] {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(search(in, 8));
        for (int i=0; i<10; i++) {
            System.out.println("i: " + i + " -> " + search(in, i));
        }
    }
}
