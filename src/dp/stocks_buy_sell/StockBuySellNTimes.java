package dp.stocks_buy_sell;

public class StockBuySellNTimes {
    private static int findMaxProfit(int [] price){
        if(price == null || price.length == 0){
            return 0;
        }
        int n = price.length;
        /**
         * initially our buying day and selling day are 0. We follow valley peak strategy i.e. we buy on the dip
         * and sell at the peak 
         * */
        int sellingDay = 0, buyingDay = 0, profit = 0;
        for(int i = 1; i < n; i++){
            if(price[i] >= price[i-1]){
                sellingDay++;
            }
            else {
                profit += price[sellingDay] - price[buyingDay];
                buyingDay = sellingDay = i;
            }
        }
        //This is for last stroke of up
        profit += price[sellingDay] - price[buyingDay];
        return profit;

    }

    public static void main(String[] args) {
        int [] price = {1,2,3};
        System.out.println("Max profit after buying and selling N times are : " + findMaxProfit(price));
    }
}
