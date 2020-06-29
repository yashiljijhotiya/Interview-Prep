package dp.fibonacci;
/* Recursive TC : O(2^n)
*  Top Down TC : O(n) SC : O(n)
* */
public class Fibonacci {
    // recursive approach
    private static int fibRec(int n){
        if(n < 2){
            return n;
        }
        return fibRec(n-1) + fibRec(n-2);
    }

    //Top Down approach
    private static int fibTD(int n){
        int dp [] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fibRec(5));
        System.out.println(fibTD(5));

    }
}
