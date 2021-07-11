package dp.grid;
/*
Leetcode # 62
TC: O(m*n)
SC: )(m*n)
*/

public class CountUniquePaths {

    private static int findAllUniquePaths(int [][] grid){
        if(grid == null){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int [m+1][n+1];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j]+ dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int grid[][] = {{1,2,3},{4,5,6}, {7,8,9}};
        System.out.println("Total no. of unique paths are : "+ findAllUniquePaths(grid));
    }
}
