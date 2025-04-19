public class stockBuySell {
    public static void main(String[] args) {
        int []prices={7,1,5,4,3,6 };
        System.out.println(       bestTimeToBuyAndSellStock(prices));
    }


    public static int bestTimeToBuyAndSellStock(int []prices) {
        int min=prices[0];//buying the stock
        int profit=0;
        for (int i = 1; i < prices.length ; i++) {
            profit=Math.max(profit,prices[i]-min);
            min=Math.min(min,prices[i]);
        }

        return profit;

    }
}
