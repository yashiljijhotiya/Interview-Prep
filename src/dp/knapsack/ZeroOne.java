package dp.knapsack;
import java.util.Arrays;
/* Rec TC : O(2^n), SC :
*  Memoize TC : O(n^2), SC : O(n^2) + call stack
*  Top down TC : O(n^2)
* */
public class ZeroOne {

    //recursive approach
    private static int knapsackRec(int weight[], int val[], int capacity, int n){
        //base condition
        if(capacity == 0 || n == 0){
            return 0;
        }

        int includingProfit = 0;
        //including value to knapsack
        if(weight[n-1] <= capacity){
            includingProfit = val[n-1] + knapsackRec(weight,val,capacity-weight[n-1],n-1);
        }
        //not including value to knapsack
        int notIncludingProfit = knapsackRec(weight,val,capacity,n-1);

        return Math.max(includingProfit,notIncludingProfit);
    }

    //Memoization dp approach (bottom up approach) we will make table of n & capacity
    //coz these two variables are changing
    private static int knapsackMemoize(int weight[], int val[], int capacity, int n, int dp[][]){

        if(capacity == 0 || n == 0){
            return 0;
        }
        if(dp[n][capacity] != -1){
            return dp[n][capacity];
        }

        int includingProfit = 0;
        if(weight[n] <= capacity){
            includingProfit = knapsackMemoize(weight,val,capacity-weight[n],n-1,dp);
        }

        int notIncludingProfit = knapsackMemoize(weight,val,capacity,n-1,dp);
        dp[n][capacity] = Math.max(includingProfit,notIncludingProfit);
        return dp[n][capacity];
    }

    //Top down approach
    private static int knapsackTopDown(int weight[], int val[], int capacity){
        int n = weight.length;
        int dp[][] = new int [n][capacity+1];

        for(int i = 0; i < n; i++){
            dp[i][0] = 0;
        }

        for(int i = 0; i <= capacity; i++){
            dp[0][i] = 0;
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j <= capacity; j++){
                int includingProfit = 0, notIncludingProfit = 0;
                if(weight[i] <= j){
                    includingProfit = val[i-1]+ dp[i-1][j-weight[i-1]];
                }
                notIncludingProfit = dp[i-1][j];
                dp[i][j] = Math.max(includingProfit,notIncludingProfit);
            }
        }
        return dp[n-1][capacity];
    }


    public static void main(String[] args) {
        int weight[] = {1, 2, 3, 5};
        int value[] = {1, 6, 10, 16};
        int capacity = 7;
        int n = weight.length;
        int dp[][] = new int [n+1][capacity+1];
        //Arrays.fill(dp,-1);
        System.out.println(knapsackTopDown(weight,value,7));
    }
}
