package grind75.Week2;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int[] d = new int[amount+1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i=0; i<=amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (d[i] != Integer.MAX_VALUE && i+coins[j]>0 && i+coins[j]<=amount) {
                    d[i+coins[j]] = Math.min(d[i+coins[j]], d[i]+1);
                }
            }
        }

        return d[amount] == Integer.MAX_VALUE ? -1 : d[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[] {1,2147483647}, 2);
    }
}
