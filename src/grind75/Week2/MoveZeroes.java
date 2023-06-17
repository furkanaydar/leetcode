package grind75.Week2;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int l=0, r=1;
        while (l<nums.length && r<nums.length) {
            while (l<nums.length && nums[l] != 0) l++;
            r = l+1;
            while (r<nums.length && nums[r] == 0) r++;

            if (l<r && r<nums.length) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }

    }

}
