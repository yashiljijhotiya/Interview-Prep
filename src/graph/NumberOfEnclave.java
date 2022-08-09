package graph;

public class NumberOfEnclave {
    private static int [][] directions = {{1,0}, {-1,0}, {0,1},{-1,0}};

    private static int countEnclaves(int [][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int enclave = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < n; i++){
            dfs(grid, m, n, 0, i);
            dfs(grid, m, n, m-1, i);
        }
        for(int j = 0; j < m; j++){
            dfs(grid, m, n, j, 0);
            dfs(grid, m, n, j, n-1);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    enclave++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return enclave;
    }

    private static void dfs(int [][] grid, int m, int n, int i, int j){
        if(i < 0 || j < 0 ||  i >= m || j >= n || grid[i][j] == 0){
            return;
        }
        //To mark visited
        grid[i][j] = 0;
        for(int [] dir : directions){
            int x = dir[0] + i;
            int y = dir[1] + j;
            dfs(grid, m, n, x, y);
        }
    }



    public static void main(String[] args) {

    }
}
