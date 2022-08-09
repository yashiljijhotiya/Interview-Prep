package dp.stocks_buy_sell;

public class StockBuySellOne {

    private static int findMaxProfit(int [] price){
        if(price == null || price.length == 0){
            return 0;
        }
        int n = price.length;
        int maxProfit = 0;
        int profitIfSoldToday = 0;
        int leastSoFar = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(price[i] < leastSoFar){
                leastSoFar = price[i];
            }
            profitIfSoldToday = price[i] - leastSoFar;
            if(profitIfSoldToday > maxProfit){
                maxProfit = profitIfSoldToday;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int [] price = {7,1,5,6,3,4};
        System.out.println("Max Profit earn in buying and selling 1 stock : " + findMaxProfit(price));

    }

}
