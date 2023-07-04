package grind75.Week6;

import java.util.Arrays;

public class CombinationSum4 {

    public int combinationSum4(int[] nums, int target) {
        int[] d = new int[target+1];
        d[0] = 1;
        Arrays.sort(nums);
        for (int i=0; i<=target; i++) {
            for (int j=0; j<nums.length && i+nums[j] <= target; j++) {
                if (d[i] != 0) {
                    d[i+nums[j]]+=d[i];
                }
            }
        }

        return d[target];
    }

    public static void main(String[] args) {
        CombinationSum4 cs = new CombinationSum4();
        cs.combinationSum4(new int[] {1,2,3}, 4);
    }
}
