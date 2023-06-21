package grind75.Week3;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static List<Integer> dfs(int[][] matrix, int x0, int y0, int x1, int y1, List<Integer> res) {
        if (x0>x1 || y0>y1) {
            return res;
        }

        if (x0 == x1) {
            while (y0<=y1) {
                res.add(matrix[x0][y0++]);
            }
            return res;
        }

        int tmp=y0;
        while (tmp<=y1) {
            res.add(matrix[x0][tmp++]);
        }

        tmp=x0+1;
        while (tmp<=x1) {
            res.add(matrix[tmp++][y1]);
        }

        tmp=y1-1;
        while (tmp>=y0) {
            res.add(matrix[x1][tmp--]);
        }

        tmp=x1-1;
        while (tmp>x0 && y0 != y1) {
            res.add(matrix[tmp--][y0]);
        }

        return dfs(matrix, x0+1, y0+1, x1-1, y1-1, res);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        return dfs(matrix, 0, 0, matrix.length-1, matrix[0].length-1, new ArrayList<>());
    }

    public static void main(String[] args) {
        int[][] n = new int[][] {
                {7},
                {9},
                {6}
        };

        List<Integer> r = spiralOrder(n);
        int x = 5;
    }
}
