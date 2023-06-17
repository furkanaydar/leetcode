package grind75.Week2;

public class NumberOfIslandsDFS {
    public boolean[][] h;
    int[][] d = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void dfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';

        for (int i=0; i<4; i++) {
            int nx=x+d[i][0], ny=y+d[i][1];
            if (nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny] == '1') {
                dfs(grid, nx, ny);
            }
        }
    }

    public int numberOfIslands(char[][] grid) {
        int res=0;
        h = new boolean[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
}
