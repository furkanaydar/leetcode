package grind75.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public void rec(int[] candidates, int target, int index, List<Integer> cur, List<List<Integer>> result) {
        if (target < 0 || index>=candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(List.copyOf(cur));
            return;
        }

        cur.add(candidates[index]);
        rec(candidates, target-candidates[index], index, cur, result);
        cur.remove(cur.size()-1);
        rec(candidates, target, index+1, cur, result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        rec(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }
}
