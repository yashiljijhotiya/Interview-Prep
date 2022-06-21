package dp.leetcode;

public class WaterInGlass {

    private static double getAmountOfWaterPresent(int k, int r, int c){
        double [][] dp = new double[k+1][k+1];
        dp[0][0] = k;
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j <= i; j++){
                if(dp[i][j] > 1){
                    double spare = dp[i][j] - 1;
                    dp[i][j] = 1;
                    //bottom left
                    dp[i+1][j] = spare/2;
                    dp[i+1][j+1] = spare/2;
                }
            }
        }
        return dp[r][c];
    }
    public static void main(String[] args) {

    }
}
