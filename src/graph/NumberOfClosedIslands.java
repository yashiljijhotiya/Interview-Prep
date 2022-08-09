package graph;
/**
 * Leetcode : 1254
 * Approach : Any Island found on the parameter of matrix will not be consider as closed one's, so we'll not going to consider them { i = 0, i = r-1, j = 0, j = c-1 }
 * TC : O(m*n)
 * */
public class NumberOfClosedIslands {
    private static int [][] direction = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int findClosedIslands(int islands [][]){
        int closedIslands = 0;
        if(islands == null || islands.length == 0){
            return 0;
        }
        int m = islands.length, n = islands[0].length;
        //for traversing top & bottom border
        for(int i= 0; i < n; i++){
            dfs(islands, m, n, 0, i);
            dfs(islands, m, n, m-1, i);
        }
        //for traversing left and right border
        for(int i = 0; i < m; i++){
            dfs(islands, m, n, i, 0);
            dfs(islands, m, n, i, n-1);

        }
        closedIslands = countIsland(islands, m, n);
        return closedIslands;
    }

    private static void dfs(int islands[][], int m, int n, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || islands[i][j] != 0){
            return;
        }
        islands[i][j] = 1;
        for (int dir [] : direction){
            int x = dir[0] + i;
            int y = dir[1] + j;
            dfs(islands, m, n, x, y);
        }
    }

    private static int countIsland(int [][] islands, int m, int n){
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(islands[i][j] == 0){
                    count++;
                    dfs(islands, m, n, i, j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int islands[][] = {{1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}};

        System.out.println(findClosedIslands(islands));
    }
}
