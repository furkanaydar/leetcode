package grind75.Week5;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceLinear {

    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int n: nums) {
            s.add(n);
        }

        int res=0;

        for (int num : nums) {
            int c = 0;
            int it = num;
            while (s.contains(it)) {
                s.remove(it);
                c++;
                it--;
            }

            it = num + 1;
            while (s.contains(it)) {
                s.remove(it);
                c++;
                it++;
            }

            res = Math.max(res, c);
        }

        return res;
    }
}
