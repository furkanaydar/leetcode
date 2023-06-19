package grind75.Week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    static class Entry implements Comparable<Entry> {
        int s, e;

        public Entry(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Entry o) {
            if (this.s == o.s) {
                return this.e-o.e;
            }

            return this.s-o.s;
        }
    }

    public static int[][] merge(int[][] intervals) {
        List<Entry> l = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
        for (int i=0; i<intervals.length; i++) {
            if (i>0 && intervals[i][0] <= l.get(l.size()-1).e) {
                Entry elem = l.get(l.size()-1);
                l.remove(l.size()-1);
                l.add(new Entry(Math.min(elem.s, intervals[i][0]),
                        Math.max(elem.e, intervals[i][1])));
            } else {
                l.add(new Entry(intervals[i][0], intervals[i][1]));
            }
        }

        int[][] res = new int[l.size()][2];

        for (int i=0; i<l.size(); i++) {
            res[i][0] = l.get(i).s;
            res[i][1] = l.get(i).e;
        }

        return res;
    }

    public static void main(String[] args) {
        merge(new int[][]{{1, 4}, {0, 2}, {3, 5}});
    }
}
