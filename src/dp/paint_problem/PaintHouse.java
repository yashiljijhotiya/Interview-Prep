package dp.paint_problem;

public class PaintHouse {

    private static int findCost(int houseColor[][]){
        int n = houseColor.length;
        int dp[][] = new int [n][3];
        dp[0][0] = houseColor[0][0];
        dp[0][1] = houseColor[0][1];
        dp[0][2] = houseColor[0][2];

        for(int i = 1; i < n; i++){
            dp[i][0] = houseColor[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = houseColor[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = houseColor[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

    public static void main(String[] args) {
        /** here row represent house no. and column represent the (r,g,b) colors cost */
        int houseColor[][] = {{1,5,7},{5,8,4},{3,2,9},{1,2,4}};
        System.out.println("Min cost to paint all the houses are : " + findCost(houseColor));

    }
}
