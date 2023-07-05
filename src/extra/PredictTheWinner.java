package extra;

import java.util.Arrays;

public class PredictTheWinner {

    public int dp(int[] nums, int i, int j, int[][][] d, int dIndex) {
        if (d[i][j][dIndex] != -1) {
            return d[i][j][dIndex];
        }

        int minIndex = nums[i] < nums[j] ? i : j;
        int maxIndex = nums[i] < nums[j] ? j : i;

        if (i+1 == j) {
            return d[i][j][dIndex] = dIndex == 0 ? nums[maxIndex] : nums[minIndex];
        }

        int takeLeft = dp(nums, i+1, j, d, dIndex == 0 ? 1 : 0);
        int takeRight = dp(nums, i, j-1, d, dIndex == 0 ? 1 : 0);

        if (dIndex == 0) {
            takeLeft+=nums[i];
            takeRight+=nums[j];
            return d[i][j][dIndex] = Math.max(takeLeft, takeRight);
        }

        return d[i][j][dIndex] = Math.min(takeLeft, takeRight);
    }

    public boolean predictTheWinner(int[] nums) {
        int[][][] d = new int[nums.length][nums.length][2];
        int half = (Arrays.stream(nums).sum()+1)/2;
        for (int i=0; i<nums.length; i++) {
            for (int j=0; j<nums.length; j++) {
                d[i][j][0] = d[i][j][1] = -1;
            }
        }

        for (int i=0; i<nums.length; i++) {
            d[i][i][0] = d[i][i][1] = nums[i];
        }

        return dp(nums, 0, nums.length-1, d, 0)>=half;
    }
}
