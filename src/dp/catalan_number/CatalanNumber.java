package dp.catalan_number;
/**
 *  Cn = C0*Cn-1+C1*Cn-2 + C2*Cn-3.....Cn-1*C0
 *  C0 = 1, C1 = 1
 *  1,1,2,5,14,42.....
 * **/
public class CatalanNumber {

    private static int findCatalanNumber(int n){
        int[] dp = new int [n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println(findCatalanNumber(3));
    }
}
