package coding_paterrn.stock_buy_sell;

public class StockBuySellSingleMax {

    private static int findMaxProfit(int [] stocks){
        int len = stocks.length;
        if(len < 2){
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for(int price : stocks){
            maxProfit = Math.max(maxProfit, price - minValue);
            minValue = Math.min(minValue, price);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int stocks[] = {100, 180, 260, 310,40, 535, 900};
        System.out.println("max profit received in buying and selling stock once is : " +findMaxProfit(stocks));
    }
}
