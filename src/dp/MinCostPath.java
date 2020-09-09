package dp;

public class MinCostPath {

    private static int findMinCost(int mat [][]){

        StringBuilder result = new StringBuilder();
        result.append(" ");
        result.append("");
        if(mat == null || mat.length == 0){
            return 0;
        }
        int m = mat.length;
        int n = mat[0].length;
        int cost[][] = new int[m+1][n+1];
        cost[0][0] = mat[0][0];

        for(int i = 1; i < m; i++){
            cost[i][0] = cost[i-1][0]+mat[i][0];
        }

        for(int j = 1; j < n; j++){
            cost[0][j] = cost[0][j-1] + mat[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                cost[i][j] = Math.min(Math.min(cost[i-1][j-1],cost[i-1][j]), cost[i][j-1]) + mat[i][j];
            }
        }
        return cost[m-1][n-1];
    }

    public static void main(String[] args) {
        int mat[][] = {{1,2,3},
                       {4,8,1},
                       {1,5,3}};
        System.out.println("min cost to reach end is : "+ findMinCost(mat));
    }
}
