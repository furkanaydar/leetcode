package grind75.Week2;

import java.util.*;

public class InsertInterval {

    static class Interval implements Comparable<Interval> {
        int s, e;

        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        public Interval(int[] interval) {
            this.s = interval[0];
            this.e = interval[1];
        }

        @Override
        public int compareTo(Interval o) {
            return s-o.s<0 ? -1 : 1;
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> l = new ArrayList<>();
        for (int[] interval: intervals) {
            l.add(new Interval(interval));
        }

        l.add(new Interval(newInterval));
        Collections.sort(l);
        int p=0;

        List<Interval> res = new ArrayList<>();
        while (p<l.size()) {
            int q=p;
            Interval current = l.get(p);
            Interval toAdd = new Interval(current.s, current.e);
            while (q+1<l.size() && toAdd.e >= l.get(q+1).s) {
                toAdd.s = current.s;
                toAdd.e = Math.max(l.get(q+1).e, toAdd.e);
                q++;
            }

            res.add(toAdd);
            p=++q;
        }

        int[][] arrRes = new int[res.size()][2];
        for (int i=0; i<res.size(); i++) {
            arrRes[i][0] = res.get(i).s;
            arrRes[i][1] = res.get(i).e;
        }

        return arrRes;
    }

    public static void main(String[] args) {
       // insert(new int[][]{{1, 3}, {6, 9}}, new int[] {2, 5});
        insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8});

    }

}
