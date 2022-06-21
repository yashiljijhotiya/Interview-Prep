package dp.catalan_number;
/**
 *   n= 3 -> (10,20,30)                   10           20            30
 *   0 = 1                              /  \        /    \        /      \
 *   1 = 1                            0    [20,30] [10] [30]   [10, 20]  0
 *   2 = 2                            1 *  2   +   1 * 1    +  2 * 1   = 5
 *   3 = 5
 * **/
public class CountBST {

    private static int countBST(int n){
        int dp[] =new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
           int l = 0;
           int r = i-1;
           while(l <= i-1){
               dp[i] += dp[l]*dp[r];
               l++;
               r--;
           }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("no. of BST possible for : " + countBST(4));

    }
}
