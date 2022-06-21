package dp.catalan_number;

/**
 *  Given pairs of bracket count the no. of arrangements possible. Closed bracket can not be greater than open bracket at any point of time
 * */
public class CountBracketArrangements {

    private static int countWays(int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int inside = i - 1;
            int outside = 0;
            while(inside >= 0){
                dp[i] += dp[inside]*dp[outside];
                inside--;
                outside++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("no. of ways to arrange pairs of brackets are : " + countWays(4));
    }
}
