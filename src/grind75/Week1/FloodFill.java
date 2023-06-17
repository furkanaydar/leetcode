package grind75.Week1;

public class FloodFill {

    static final int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void dfs(int[][] image, int x, int y, int c, int nc) {
        if (x < 0 || x >= image.length || y < 0 || y >= image[0].length) {
            return;
        }

        if (image[x][y] != c) {
            return;
        }

        image[x][y] = nc;

        for (int i=0; i<4; i++) {
            dfs(image,x + dirs[i][0], y + dirs[i][1], c, nc);
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            // prevent loop
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public static void main(String[] args) {
        int[][] img = new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] res = floodFill(img, 1, 1, 2);
        int x = 5;
    }
}
