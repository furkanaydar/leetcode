package grind75.Week3;

public class WordSearch {

    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] h) {
        h[x][y] = true;

        if (index == word.length()-1) {
            return true;
        }

        for (int i=0; i<4; i++) {
            int nx = x+dirs[i][0];
            int ny = y+dirs[i][1];

            if (nx>=0 && nx<board.length && ny>=0 && ny<board[0].length && !h[nx][ny] && board[nx][ny] == word.charAt(index+1)) {
                if (dfs(board, word, nx, ny, index+1, h)) {
                    return true;
                }
            }
        }

        h[x][y] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0, new boolean[6][6])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
