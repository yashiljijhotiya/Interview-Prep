package dp;
/*@author: Yashil (18-04-20)
*calculate total path to reach the end
* */
public class TotalPaths {

    private static int countTotalPath(int grid[][]){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int path[][] = new int[m+1][n+1];

        for(int i = 0; i < m; i++){
            path[i][0] = 1;
        }

        for(int j = 0; j < n; j++){
            path[0][j] = 1;
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                path[i][j] = path[i-1][j]+path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
        int grid[][] = {{1,2,3,4}, {4,5,6,4}, {7,8,9,3}, {12,3,1,1}};
        System.out.println("Total paths are :" +countTotalPath(grid));
    }
}
