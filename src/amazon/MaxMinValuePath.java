package amazon;
/*Input:
[[5, 1],
 [4, 5]]

Output: 4
Explanation:
Possible paths:
5 → 1 → 5 => min value is 1
5 → 4 → 5 => min value is 4
Return the max value among minimum values => max(4, 1) = 4.
*
TC : O(r*c)
*
* */
public class MaxMinValuePath {

    private static int maxPathScore(int paths[][]){
        int maxPath = Integer.MIN_VALUE;
        if(paths == null || paths.length == 0){
            return 0;
        }
        int r = paths.length, c = paths[0].length;
        int dp[][] = new int [r][c];
        dp[0][0] = Integer.MAX_VALUE;

        for(int i = 0; i < r; i++ ){
            for(int j = 0; j < c; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = paths[i][j];
                    continue;
                }
                int top = i > 0 ? dp[i-1][j] : Integer.MIN_VALUE;
                int left = j > 0 ? dp[i][j-1] : Integer.MIN_VALUE;
                dp[i][j] = Math.max(Math.min(top, paths[i][j]), Math.min(left, paths[i][j]));
            }
        }
        return dp[r-1][c-1];
    }


    public static void main(String[] args) {
        int paths[][] = {{5,1},
                         {4,5}};
        System.out.println(maxPathScore(paths));
    }

}
