package dp.grid;
/*Leetcode #63
TC: O(m*n)
SC: O(m*n)
* */
public class CountUniquePathsWithObstacles {
    private static int findAllUniquePaths(int grid[][]){
        if(grid == null || grid[0][0] == 1){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int dp [][] = new int[m+1][n+1];
        boolean isObstacle = false;
        //filled 1st rows
        for(int i = 0; i < n; i++){
            if(isObstacle || dp[0][i] == 1){
                isObstacle = true;
                dp[0][i] = 0;
            }
            else {
                dp[0][i] = 1;
            }
        }

        isObstacle = false;
        //filled 1st column
        for(int i = 0; i < m; i++){
            if(isObstacle || dp[i][0] == 1){
                isObstacle = true;
                dp[i][0] = 0;
            }
            else {
                dp[i][0] = 1;
            }
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }

            }
        }

        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int grid[][] = {{0,0,0,0}, {1,0,1,0}, {0,0,0,0}};
        System.out.println("total unique paths are : "+ findAllUniquePaths(grid));
    }
}
