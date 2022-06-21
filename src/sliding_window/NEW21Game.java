package sliding_window;
/**
 *  Leetcode: 837 (med) (DP, Sliding window)
 *  [1.... maxPts] eg :[1,2,3]
 *  k = let say 18 Threshold
 *  dp[i] = is the probability of reaching number i
 *  dp[14] = dp[11]*p(3)+dp[12]*p(2)+dp[13]*p(1)
 *  but probability of every event is equal
 *  dp[i] = dp[i-1]*(1/maxPts)+ dp[i-2]*(1/maxPts)...dp[i-maxPts]*(1/maxPts)
 *  dp[i] = (1/maxPts)*(dp[i-1]+ dp[i-2] + ....+ dp[i-maxPts])
 * */
public class NEW21Game {

    private static double new21Game(int n, int k, int maxPts){
        if(k == 0){
            return 1.0;
        }
        double [] dp = new double[n+1];
        dp[0] = 1.0;
        double WindowSum = dp[0];
        double res = 0.0;
        for(int i = 1; i <= n; i++){
            dp[i] = WindowSum/(double) maxPts;
            if(i < k){
                // add to windowSum if we are still drawing
                WindowSum += dp[i];
            }else {
                res += dp[i];
            }
            if(i - maxPts >= 0){
                //delete last element from window
                WindowSum -= dp[i-maxPts];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new21Game(6,1,10));
    }
}
