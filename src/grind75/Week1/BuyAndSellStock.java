package grind75.Week1;

public class BuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int[][] d = new int[prices.length+1][2];

        d[0][0] = -prices[0];
        d[0][1] = 0;

        int res = 0;
        for (int i=1; i<prices.length; i++) {
            d[i][0] = Math.max(d[i-1][0], -prices[i]);
            d[i][1] = Math.max(d[i-1][1], d[i-1][0] + prices[i]);
            res = Math.max(d[i][1], res);
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
