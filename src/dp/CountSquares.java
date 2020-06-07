package dp;
/* Leetcode : Count no. of squares in binary matrix
TC: o(m*n)
SC: o(m*n)
* */
public class CountSquares {

    private static int countNoOfSquares(int mat[][]){
        if(mat.length == 0 || mat == null){
            return 0;
        }
        int count = 0, r = mat.length, c = mat[0].length;
        int dp[][] = new int[mat.length+1][mat[0].length+1];

        //fill first row
        for(int i = 0; i < c; i++){
            dp[0][i] = mat[0][i];
            count += dp[0][i];
        }

        // fill first column
        for(int i = 1; i < r; i++){
            dp[i][0] = mat[i][0];
            count += dp[i][0];
        }

        for(int i = 1; i < r; i++){
            for(int j = 1; j < c; j++){
                if(mat[i][j] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]),dp[i-1][j-1]) + 1;
                    count += dp[i][j];
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int mat[][] = {{1,1,1,0},
                       {1,1,1,0},
                       {1,1,1,1}};
        System.out.println("no.  of square formed are : " + countNoOfSquares(mat));
    }
}
