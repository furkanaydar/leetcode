package grind75.Week3;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    public void dfs(int[] nums, int index, List<Integer> cur) {
        if (index == nums.length) {
            res.add(List.copyOf(cur));
            return;
        }

        cur.add(nums[index]);
        dfs(nums, index+1, cur);
        cur.remove(cur.size()-1);
        dfs(nums, index+1, cur);
    }

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0, new ArrayList<>());
        return res;
    }
}
