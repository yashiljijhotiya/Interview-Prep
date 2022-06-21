package dp.catalan_number;

public class PolygonTriangulation {

    private static int countPolygonTriangulation(int n) {
       // triangulation of n = n-2
        n = n-2;
        int [] dp = new int [n+1];
        dp[0] =1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int l = i-1;
            int r = 0;
            while(l <= 0){
                dp[i] += dp[l]*dp[r];
                l--;
                r++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("no. triangulation formed in the given polygon are : " + countPolygonTriangulation(4));
    }
}
