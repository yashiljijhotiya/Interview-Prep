package dp;
/* calculate no. of ways to reach nth stair using 1,2 and 3 steps
* */
public class StairCase {

    private static  int countWays(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;//{1}
        dp[1] = 1; //{1}
        dp[2] = 2; //{1,1} {2}

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countWays(3));
    }

}
