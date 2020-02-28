package leetcode;

public class WordSearch {

    private static boolean isExist(char[][] board, String word){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char [][] board, int row, int col, int count, String word){
        if(word.length() == count){
            return true;
        }
        if(row >= board.length || row < 0 || col >= board[row].length || col < 0 || board[row][col] != word.charAt(count)){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = ' ';
        boolean found = dfs(board,row+1, col, count++, word) || dfs(board, row, col+1, count++, word)
                         || dfs(board, row, col-1, count++, word) || dfs(board, row - 1 ,col, count++, word );

        board[row][col] = temp;
       return found;
    }
    public static void main(String[] args) {
        char board[][] = {{'A','B','C','E'}, {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println(word1+ " exist :" +isExist(board,word3));

    }
}
