package dp;

import java.util.Arrays;

public class GoldMine {

    private static int findMaxGold(int [][] goldMine){
        if(goldMine == null || goldMine.length == 0){
            return 0;
        }
        int r = goldMine.length;
        int c = goldMine[0].length;
        int dp[][] = new int [r][c];

        for(int [] row : goldMine){
            Arrays.fill(goldMine,0);
        }


     return dp[r][c];
    }

    public static void main(String[] args) {
     int goldMine[][] = {{1,3,3},
                         {2,1,4},
                         {0,6,4}};

    }
}
