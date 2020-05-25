package dp;

public class MaximalSquareArea {

    private static int maxSquareArea(int mat[][]){
        if(mat == null || mat.length == 0){
            return 0;
        }
        int largestArea = 0, r = mat.length, c = mat[0].length;

        int dp[][] = new int [r+1][c+1];
        for(int i = 0; i < c; i++){
            dp[0][i] = 0;
        }
        for(int i = 0; i < r; i++){
            dp[i][0] = 0;
        }

        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(mat[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    if(largestArea < dp[i][j]){
                        largestArea = dp[i][j];
                    }
                }
            }
        }

        return largestArea * largestArea;
    }


    public static void main(String[] args) {
        int mat[][] = {{1,1,1,0},
                       {1,1,1,1},
                       {0,1,1,1},
                       {1,1,1,1}};

        System.out.println("Largest Area of square : " + maxSquareArea(mat));

    }
}
