package grind75.Week2;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        Arrays.sort(nums);

        for (int i=0; i<nums.length-1; i++) {
            int k=nums.length-1;
            int j=i+1;

            while (j<k) {
                int s = nums[i]+nums[j]+nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else {
                    res.add(List.of(nums[i], nums[j++], nums[k]));
                }
            }
        }


        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        threeSum(new int[] {-1,0,1,2,-1,-4});
    }

}
