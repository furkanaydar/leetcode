package grind75.Week1;

public class CountingBits {

    public int[] countBits(int n) {
        int[] d = new int[n+1];

        if (n == 0) {
            return new int[] {0};
        }

        if (n == 1) {
            return new int[] {0, 1};
        }

        d[0] = 0;
        d[1] = 1;
        d[2] = 1;

        int lastPowerOfTwo = 1;
        for (int i=1; i<=n; i++) {
            if (i == lastPowerOfTwo*2) {
                lastPowerOfTwo = i;
                d[i] = 1;
            } else {
                d[i] = d[lastPowerOfTwo] + d[i-lastPowerOfTwo];
            }
        }

        return d;
    }
}
