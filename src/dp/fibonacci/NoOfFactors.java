package dp.fibonacci;
/** no. of factors using 1,3,4
* Recursive : TC: O(3^n)
* Top down : TC : O(n) SC : O(n)
* */
public class NoOfFactors {

    private static int countFactorsRec(int n){
        if(n == 0){
            return 1; // base case
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }

        return countFactorsRec(n-1) + countFactorsRec(n-3) + countFactorsRec(n-4);
    }

    //Top down approach
    private static int countFactorsTD(int n){
       int dp[] = new int [n+1];
       dp[0] = 1;
       dp[1] = 1;
       dp[2] = 1;
       dp[3] = 2;
       for(int i = 4; i <= n; i++){
           dp[i] = dp[i-1]+ dp[i-3]+dp[i-4];
       }
       return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(countFactorsRec(5));
        System.out.println(countFactorsTD(5));

    }
}
