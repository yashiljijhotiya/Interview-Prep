package dp.stocks_buy_sell;

/**
 * Leetcode: 123
 * Atmost 2 transactions are allowed
 */
public class StockBuySellTwo {
    private static int findMaxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[] left = new int[n];
        int[] right = new int[n];
        //Bidirectional DP logic
        // left to right traversal
        int min = prices[0];
        left[0] = 0;//as no profit on buy & sell on same day
        for (int i = 1; i < n; i++) {
            //1. update buy price
            if (min > prices[i]) {
                min = prices[i];
            }
            //2. calculate current profit
            int profit = prices[i] - min;
            //3. fill left array
            left[i] = Math.max(left[i - 1], profit);
        }
        //right to left traversal
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            //1. update sell price
            if (prices[i] > max) {
                max = prices[i];
            }
            // 2. calculate current profit
            int profit = max - prices[i];
            //3. fill the array
            right[i] = Math.max(right[i + 1], profit);
        }
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }

        return maxProfit;
    }

    private static int findMaxProfitOptimized(int[] prices) {
        int c1 = Integer.MAX_VALUE, c2 = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        for (int i = 0; i < prices.length; i++) {
            c1 = Math.min(c1, prices[i]);
            p1 = Math.max(p1, prices[i] - c1);
            c2 = Math.min(c2, prices[i] - p1);//effective buying price
            p2 = Math.max(p2, prices[i] - c2);
        }
        return p2;
    }

    public static void main(String[] args) {
        int prices[] = {3,3,5,0,0,3,1,4};
        System.out.println(findMaxProfitOptimized(prices));
    }
}
