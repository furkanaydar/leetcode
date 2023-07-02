package grind75.Week5;

public class JumpGame {
    Boolean[] d;

    public boolean rec(int[] nums, int ind) {
        if (d[ind] != null) {
            return d[ind];
        }

        if (ind == nums.length-1) {
            return d[ind]=true;
        }

        for (int i=1; i<=nums[ind]; i++) {
            if (ind + i < nums.length && rec(nums, ind+i)) {
                return d[ind] = true;
            }
        }

        return d[ind] = false;
    }

    public boolean canJump(int[] nums) {
        d = new Boolean[nums.length];
        rec(nums, 0);
        return d[nums.length-1] != null && d[nums.length-1];
    }
}
