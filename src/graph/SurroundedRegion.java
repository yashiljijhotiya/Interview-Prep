package graph;

public class SurroundedRegion {

    private static int dir [][] = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    private static void noOfSurroundedRegions(char [][] board){
        if(board == null || board.length == 0){
            return;
        }
        int m = board.length, n = board[0].length;
        /** For traversing top and bottom border */
        for(int i = 0; i < n; i++){
            dfs(board,m ,n ,0, i);
            dfs(board, m, n, m-1, i);
        }
        /** For traversing left and right border*/
        for(int i = 0; i < m; i++){
            dfs(board, m, n, i, 0);
            dfs(board, m, n, i, n-1);
        }
        markBoard(board, m, n);
    }

    private static void dfs(char [][] board, int m, int n, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || board[i][j] == 'X'){
            return;
        }
        board[i][j] = 'M';
        for(int [] direction : dir){
            int x = direction[0] + i;
            int y = direction[1] + j;
            dfs(board, m, n, x, y);
        }
    }

    private static void markBoard(char [][] board, int m, int n){
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'M'){
                    board[i][j] = '0';
                }
                else if(board[i][j] == '0'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char [][] board = {{'X', 'X', 'X', 'X'},
                {'X', '0', '0', 'X'},
                {'X', 'X', '0', 'X'},
                {'X', '0', 'X', 'X'}};

    }
}
