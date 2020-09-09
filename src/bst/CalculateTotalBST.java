package bst;
// TC : Catalan no.
/*   (root)
     /    \
    l = 3     r = 4
    so total combination possible are =  l*r(3*4 = 12)
 n = 3 = [1,2,3]
   1           2
  / \         / \
null [2,3]   1   3
C0   C1      C1  C2
*
  C2 = C0C1 + C1C0
  C3 = C0C3 + C1C2 + C2C1 + C3C0
* */
public class CalculateTotalBST {

    private static int calculateBST(int n){
        if(n == 0){
            return 0;
        }
        int dp[] = new int [n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(calculateBST(5));
    }
}
