package dp.stocks_buy_sell;

public class StockBuySellNTimes {
    private static int findMaxProfit(int[] price) {
        if (price == null || price.length == 0) {
            return 0;
        }
        int profit = 0;
        //start with index 1 and compare the price with prev one
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                profit += price[i] - price[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] price = {1, 2, 3};
        System.out.println("Max profit after buying and selling N times are : " + findMaxProfit(price));
    }
}
