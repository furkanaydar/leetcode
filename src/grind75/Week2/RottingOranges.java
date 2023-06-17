package grind75.Week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int orangesRotting(int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] h = new boolean[grid.length+1][grid[0].length+1];
        int f=0, res=0;
        int[][] d = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Point(i, j));
                    h[i][j] = true;
                } else if (grid[i][j] == 1) {
                    f++;
                }
            }
        }

        while (!q.isEmpty()) {
            boolean r=false;
            List<Point> l = new ArrayList<>();
            while (!q.isEmpty()) {
                l.add(q.poll());
            }

            for (Point p: l) {
                for (int i=0; i<4; i++) {
                    int nx=p.x+d[i][0];
                    int ny=p.y+d[i][1];

                    if (nx>=0 &&
                            nx<grid.length &&
                            ny>=0 &&
                            ny<grid[0].length &&
                            !h[nx][ny] &&
                            grid[nx][ny] == 1) {
                        q.add(new Point(nx, ny));
                        h[nx][ny]=true;
                        grid[nx][ny]=2;
                        f--;
                        r=true;
                    }
                }
            }

            res+=r?1:0;
        }

        return f != 0 ? -1 : res;
    }

    public static void main(String[] args) {
        int[][] inp = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        int[][] inp2 = new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        int[][] inp3 = new int[][] {{0, 2, 2}};

        System.out.println(orangesRotting(inp3));
        //System.out.println(orangesRotting(inp2));
        //System.out.println(orangesRotting(inp3));

    }
}
