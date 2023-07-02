package grind75.Week4;

public class HouseRobber {

    public static int rob(int[] nums) {
        int r=0;
        int[] d = new int[nums.length];
        d[0]=nums[0];
        d[1]=Math.max(nums[0], nums[1]);

        for (int i=2; i<nums.length; i++) {
            d[i] = Math.max(nums[i]+d[i-2], d[i-1]);
            r=Math.max(r, d[i]);
        }

        return r;
    }

    public static void main(String[] args) {
        rob(new int[] {1,2,3,1});
    }
}
