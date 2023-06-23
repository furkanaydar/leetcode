package grind75.Week3;

public class HouseRobber {

    public int rob(int[] nums) {
        int[][] d = new int[nums.length][2];
        d[0][0] = 0;
        d[0][1] = nums[0];

        for (int i=1; i<nums.length; i++) {
            d[i][1] = Math.max(d[i-1][0]+nums[i], d[i-1][1]);
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]);
        }

        return Math.max(d[nums.length-1][0], d[nums.length-1][1]);
    }
}
