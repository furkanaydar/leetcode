package grind75.Week3;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void rec(int[] nums, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!cur.contains(nums[i])) { // could use set for o(1) check
                cur.add(nums[i]);
                rec(nums, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        rec(nums, new ArrayList<>(), res);
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1,2,3});
        int x = 4;
    }
}
