package grind75.Week1;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            if (pos.containsKey(target-nums[i])) {
                return new int[] {pos.get(target-nums[i]), i};
            }

            pos.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[] {3, 3}, 6);
        System.out.println(res[0] + " " + res[1]);
    }
}
