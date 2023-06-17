package grind75.Week1;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer n: nums) {
            if (set.contains(n)) {
                return true;
            }

            set.add(n);
        }

        return false;
    }
}
