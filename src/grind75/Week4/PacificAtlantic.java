package grind75.Week4;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlantic {
    int[][] d = new int[][] {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    void dfs(int[][] heights, int x, int y, boolean[][] h) {
        if (h[x][y]) {
            return;
        }

        h[x][y] = true;
        for (int[] nd: d) {
            int nx = x+nd[0], ny = y+nd[1];
            if (nx<0 || nx>= heights.length || ny<0 || ny>=heights[0].length) {
                continue;
            }

            if (!h[nx][ny] && heights[x][y] <= heights[nx][ny]) {
                dfs(heights, nx, ny, h);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacificVisited = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVisited = new boolean[heights.length][heights[0].length];

        for (int i=0; i<heights.length; i++) {
            dfs(heights, i, 0, pacificVisited);
            dfs(heights, i, heights[i].length-1, atlanticVisited);
        }

        for (int i=0; i<heights[0].length; i++) {
            dfs(heights, 0, i, pacificVisited);
            dfs(heights, heights.length-1, i, atlanticVisited);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0; i<pacificVisited.length; i++) {
            for (int j=0; j<pacificVisited[0].length; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }
}
