package grind75.Week5;

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int[][] d = new int[matrix.length][matrix[0].length];
        int res=0;

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    d[i][j] = 1;
                    res=1;
                }
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    d[i][j] = Math.min(d[i-1][j-1], Math.min(d[i-1][j], d[i][j-1])) + 1;
                    res = Math.max(res, d[i][j]);
                }
            }
        }

        return res*res;
    }

    public static void main(String[] args) {
        char[][] in = new char[][] {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'},
        };
        char[][] in2 = new char[][] {
                {'1'}
                };
        MaximalSquare ms = new MaximalSquare();
        ms.maximalSquare(in);
    }
}
