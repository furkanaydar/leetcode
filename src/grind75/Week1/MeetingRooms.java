package grind75.Week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingRooms {

    static class Interval implements Comparable<Interval> {
        int s, e;

        public Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Interval o) {
            return s < o.s ? -1 : 1;
        }
    }

    public static boolean meetingRooms(List<Interval> intervals) {
        Collections.sort(intervals);
        for (int i=0; i<intervals.size()-1; i++) {
            if (intervals.get(i).e > intervals.get(i+1).s) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        List<Interval> inp = case2();
        System.out.println(meetingRooms(inp));
    }

    public static List<Interval> case1() {
        List<Interval> l = new ArrayList<>();
        l.add(new Interval(0, 30));
        l.add(new Interval(5, 10));
        l.add(new Interval(15, 20));
        return l;
    }

    public static List<Interval> case2() {
        List<Interval> l = new ArrayList<>();
        l.add(new Interval(7, 10));
        l.add(new Interval(2, 4));
        return l;
    }
}
