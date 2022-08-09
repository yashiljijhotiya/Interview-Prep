package dp.fibonacci;
/** Recursive TC : O(3^n)
*  Top Down : TC : O(n) SC : O(n)
* */
public class StairCase {

    private static int countWaysRec(int n){
        if(n == 0){
            return 1;// we don't need to take any steps, so there is only one way
        }
        if(n == 1){
            return 1; // we can take only one step to reach one step
        }
        if(n == 2){
            return 2; // we reach 2 by taking 2 steps at a time or by taking 1 steps at a time{2}, {1,1}
        }
        return countWaysRec(n-1) + countWaysRec(n-2) + countWaysRec(n-3);
    }

    //Top down
    private static int countWaysTD(int n){
        int dp[] = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2]+ dp[i-3];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(countWaysRec(3));

    }
}
