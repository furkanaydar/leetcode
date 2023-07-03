package grind75.Week6;

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0, len=matrix.length*matrix[0].length-1, r=len;

        while (l<=r) {
            int mid=l+(r-l)/2;
            int row=mid/matrix[0].length;
            int col=mid%(matrix[0].length);

            if (l == r) {
                return matrix[row][col] == target;
            }

            if (matrix[row][col] < target) {
                l=mid+1;
            } else if (matrix[row][col] > target) {
                r=mid;
            } else {
                return true;
            }
        }

        return false;
    }
}
