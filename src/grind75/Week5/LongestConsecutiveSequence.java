package grind75.Week5;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    class LCSDisjointSet {
        int[] parent;
        int[] rank;
        int maxRank;

        public LCSDisjointSet(int size) {
            this.parent = new int[size];
            this.rank = new int[size];
            for (int i=0; i<size; i++) {
                parent[i] = i;
                rank[i]=1;
            }
            this.maxRank=1;
        }

        public void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx != ry) {
                if (rank[rx] > rank[ry]) {
                    parent[ry] = rx;
                    rank[rx]+=rank[ry];
                    maxRank=Math.max(rank[rx], maxRank);
                } else {
                    parent[rx] = ry;
                    rank[ry]+=rank[rx];
                    maxRank=Math.max(rank[ry], maxRank);
                }
            }
        }

        public int find(int n) {
            if (parent[n] != n) {
                parent[n] = find(parent[n]);
            }

            return parent[n];
        }
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> valToIndex = new HashMap<>();
        LCSDisjointSet lcsDisjointSet = new LCSDisjointSet(nums.length);

        for (int i=0; i<nums.length; i++) {
            valToIndex.put(nums[i], i);
        }

        for (Integer val: valToIndex.keySet()) {
            if (valToIndex.containsKey(val-1)) {
                lcsDisjointSet.union(valToIndex.get(val), valToIndex.get(val-1));
            }

        }

        return lcsDisjointSet.maxRank;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        System.out.println(lcs.longestConsecutive(new int[] {0,3,7,2,5,8,4,6,0,1}));
        System.out.println(lcs.longestConsecutive(new int[] {100,4,200,1,3,2}));


    }
}
