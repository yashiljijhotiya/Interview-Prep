package dp.grid;
/*Leetcode#64
*TC: O(m*n)
* SC: O(m*n)
*  */
public class MinPathSum {

    private static int findMinPathSum(int [][] grid){
        if(grid == null){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int [row+1][col+1];
        //filling first row
        dp[0][0] = grid[0][0];
        for(int i = 1; i < col; i++){
            dp[0][i] = dp[0][i-1]+ grid[0][i];
        }
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }
    public static void main(String[] args) {
        int [][] grid = {{1,3,5}, {2,1,2}, {4,3,1}};
        System.out.println("Min cost path sum is : "+ findMinPathSum(grid));
    }
}
