package problem_solving;
/*Leetcode : o(n)
* */
public class StockBuySell {

    private static int maxProfitToBuySell(int price[]){
        if(price == null || price.length == 0){
            return 0;
        }
        int profit = 0;
        for(int i = 1; i < price.length; i++) {
            if (price[i] - price[i - 1] > 0) {
                profit += price[i] - price[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int stocksPrice[] = {100, 180, 260, 310, 40, 535, 695 };
        System.out.println("max profit received is : " + maxProfitToBuySell(stocksPrice));

    }
}
