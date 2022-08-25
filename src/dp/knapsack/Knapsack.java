package dp.knapsack;

public class Knapsack {

    private static int findMaxProfit(int[] wt, int[] profit, int capacity) {
        if (wt == null || wt.length == 0 || profit == null || profit.length == 0) {
            return 0;
        }
        int n = wt.length;
        int maxProfit = 0;
        //  maxProfit = findMaxProfitRec(wt, profit, capacity, n - 1);
        Integer dp[][] = new Integer[n + 1][capacity + 1];
        maxProfit = findMaxProfitMemoize(wt, profit, capacity, n - 1, dp);
        return maxProfit;
    }

    private static int findMaxProfitRec(int[] wt, int[] profit, int capacity, int size) {
        if (capacity == 0 || size == 0) {
            return 0;
        }
        if (wt[size] > capacity) {
            return findMaxProfitRec(wt, profit, capacity, size - 1);
        }
        int withProfit = profit[size] + findMaxProfitRec(wt, profit, capacity - wt[size], size - 1);
        int withoutProfit = findMaxProfitRec(wt, profit, capacity, size - 1);
        return Math.max(withoutProfit, withProfit);
    }

    private static int findMaxProfitMemoize(int[] wt, int[] profit, int capacity, int size, Integer dp[][]) {
        if (capacity == 0 || size == 0) {
            return 0;
        }
        if (dp[size][capacity] != null) {
            return dp[size][capacity];
        }
        if (wt[size] > capacity) {
            dp[size][capacity] = findMaxProfitMemoize(wt, profit, capacity, size - 1, dp);
        } else {
            int withProfit = profit[size] + findMaxProfitMemoize(wt, profit, capacity - wt[size], size - 1, dp);
            int withoutProfit = findMaxProfitMemoize(wt, profit, capacity, size - 1, dp);
            dp[size][capacity] = Math.max(withoutProfit, withProfit);
        }
        return dp[size][capacity];
    }

    private static int findMaxProfitTD(int[] wt, int[] profit, int capacity) {
        int n = wt.length;
        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (wt[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        int withProfit = profit[i-1] + dp[i - 1][j - wt[i-1]];
                        int withoutProfit = dp[i - 1][j];
                        dp[i][j] = Math.max(withoutProfit, withProfit);
                    }
                }
            }
        }
        return dp[n][n];
    }


    public static void main(String[] args) {
        int[] wt = {2, 3, 1, 4};
        int[] profit = {4, 5, 3, 7};
        int capacity = 5;
       // System.out.println("Max profit : " + findMaxProfit(wt, profit, capacity));
        System.out.println("Max profit : " + findMaxProfitTD(wt, profit, capacity));
    }
}
