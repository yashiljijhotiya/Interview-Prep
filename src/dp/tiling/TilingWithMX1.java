package dp.tiling;

public class TilingWithMX1 {

    private static int noOfWaysToTileTheFloor(int m, int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            /**
             * It is the case when floor ir m*n ie 5*4 and tiles is 5*1 so in that case there will be only one possible way
             *  */
            if (i < m) {
                dp[i] = 1;
            } else if (i == m) {
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(noOfWaysToTileTheFloor(3,8));

    }
}
