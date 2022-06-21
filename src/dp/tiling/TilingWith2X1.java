package dp.tiling;

public class TilingWith2X1 {

    private static int noOfWaysToTileTheFloor(int n){
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(noOfWaysToTileTheFloor(4));
    }
}
