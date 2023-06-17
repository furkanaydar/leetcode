package grind75.Week2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
    Also a nice solution, like quicksort:
    https://leetcode.com/problems/k-closest-points-to-origin/solutions/988655/java-quick-select-o-n-avg-2ms/
 */

public class KClosestPointsToOrigin {

    class Point implements Comparable<Point> {
        int x,y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            double td = Math.sqrt(x*x+y*y);
            double od = Math.sqrt(o.x*o.x+o.y*o.y);
            return td-od<0 ? -1 : 1;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Queue<Point> q = new PriorityQueue<>();

        for (int i=0; i<points.length; i++) {
            q.add(new Point(points[i][0], points[i][1]));
        }

        int[][] res = new int[k][2];

        for (int i=0; i<k; i++) {
            Point cur = q.poll();
            res[i][0] = cur.x;
            res[i][1] = cur.y;
        }
        return res;
    }
}
