package dp.matrix_chain_multiplication;

public class RodCutting {

    private static int maxCutProfit(int pricesLength[]){
        int len = pricesLength.length;
        int newPrices[] = new int[len+1];
        for(int i = 0; i < len; i++){
            newPrices[i+1] = pricesLength[i];
        }
        int dp[] = new int[len+1];
        dp[0] = 0;
        dp[1] = newPrices[1];
        for(int i = 2; i < dp.length; i++){
            dp[i] = newPrices[i];
            int leftIndex = 1;
            int rightIndex = i-1;
            while(leftIndex <= rightIndex){
                if(dp[leftIndex] + dp[rightIndex] > dp[i]){
                    dp[i] = dp[leftIndex] + dp[rightIndex];
                }
                leftIndex++;
                rightIndex--;
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        int [] price = {1,5,8,9,10,17,17,20};
        System.out.println(maxCutProfit(price));

    }
}
