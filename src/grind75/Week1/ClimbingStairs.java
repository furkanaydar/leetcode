package grind75.Week1;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] d = new int[46];
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;
        /*
        1 1 2
        1 2 1
        2 1 1
        2 2
        1 1 1 1
         */
        for (int i=3; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
        }

        return d[n];
    }
}
