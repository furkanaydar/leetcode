package grind75.Week1;

public class MajorityElement {
    /*
        Runtime Complexity: O(N). Because we check every element of array at most once.
        Space Complexity: Constant. Because we store the counts of at most two numbers simultaneously. (In case of conflict)
     */
    public static int divideAndGetMajority(int[] nums, int l, int r) {
        if (l+1>=r) {
            return nums[l];
        }

        int mid = l+(r-l)/2;

        int lm = divideAndGetMajority(nums, l, mid);
        int rm = divideAndGetMajority(nums, mid+1, r);

        if (lm == rm) {
            return lm;
        }

        // Resolve conflict between two sides
        int lmCount=0, rmCount=0;
        for (int i=l; i<=r; i++) {
            if (nums[i] == lm) {
                lmCount++;
            } else if (nums[i] == rm) {
                rmCount++;
            }
        }

        if (rmCount > lmCount) {
            return rm;
        }

        return lm;
    }

    public static int majorityElement(int[] nums) {
        return divideAndGetMajority(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {7,6,6,6,7,7,7}));
        System.out.println(majorityElement(new int[] {6,6,6,6,7,7,7}));
        System.out.println(majorityElement(new int[] {6,6,6,7,7,7,7}));
        System.out.println(majorityElement(new int[] {6,6,6,7,7}));
        System.out.println(majorityElement(new int[] {6,6,7,7,7}));
        System.out.println(majorityElement(new int[] {6,6,7}));
        System.out.println(majorityElement(new int[] {6,7,7}));

    }
}
