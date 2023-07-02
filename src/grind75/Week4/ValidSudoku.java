package grind75.Week4;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] groups = new boolean[9][9];

        for (int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if (Character.isDigit(board[i][j])) {
                    int n = board[i][j]-'0';
                    if (rows[i][n-1] || cols[j][n-1] || groups[(i/3)*3+j/3][n-1]) {
                        return false;
                    }
                    rows[i][n-1] = cols[j][n-1] = groups[(i/3)*3+j/3][n-1] = true;
                }
            }
        }

        return true;
    }
}
