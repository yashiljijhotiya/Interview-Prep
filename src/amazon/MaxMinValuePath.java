package amazon;

public class MaxMinValuePath {

    private static int maxPathScore(int paths[][]){
        int maxPath = Integer.MIN_VALUE;
        if(paths == null || paths.length == 0){
            return 0;
        }
        int r = paths.length, c = paths[0].length;
        int dp[][] = new int [r][c];
        dp[0][0] = Integer.MAX_VALUE;
//        for(int i = 1; i < r; i++){
//            dp[i][0] = Math.min(dp[i-1][0], paths[i][0]);
//        }
//        for(int i = 1; i < c; i++){
//            dp[0][i] = Math.min(dp[0][i-1], paths[0][i]);
//        }
//
//        for(int i = 1; i < r; i++){
//            for(int j = 1; j < c; j++){
//                if(i == r - 1 && j == c - 1){
//                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//                }
//                else {
//                    int score1 = Math.min(dp[i][j-1], paths[i][j]);
//                    int score2 = Math.min(dp[i-1][j], paths[i][j]);
//                    dp[i][j] = Math.max(score1, score2);
//                }
//            }
//        }

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
        int paths[][] = {{7,5,3},
                         {2,0,9},
                         {4,5,9}};

        System.out.println(maxPathScore(paths));
    }

}
