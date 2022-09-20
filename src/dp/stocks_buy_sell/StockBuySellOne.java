package dp.stocks_buy_sell;

public class StockBuySellOne {

    private static int findMaxProfit(int[] price) {
        if (price == null || price.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < price.length; i++) {
            if (min > price[i]) {
                min = price[i];
            }
            maxProfit = Math.max(maxProfit, price[i] - min);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] price = {7, 1, 5, 6, 3, 4};
        System.out.println("Max Profit earn in buying and selling 1 stock : " + findMaxProfit(price));

    }

}
