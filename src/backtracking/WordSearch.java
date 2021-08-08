package backtracking;
/*Leetcode 79
* TC:
* */
public class WordSearch {

    private static boolean isExist(char [][] board, String word){
        if(word == null || word.length() == 0){
            return true;
        }
        int row = board.length, col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word )){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char [][] board, int row, int col, int len, String word){
        if(len == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[row].length || board[row][col] != word.charAt(len)){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = ' ';
        boolean found = dfs(board, row+1, col, len+1, word) || dfs(board, row-1, col, len+1, word)||
                dfs(board, row, col+1, len+1, word) || dfs(board, row, col-1, len+1, word);
        board[row][col] = temp;
        return found;
    }

    public static void main(String[] args) {

    }
}
