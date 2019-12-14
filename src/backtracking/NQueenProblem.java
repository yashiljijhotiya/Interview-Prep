package backtracking;

public class NQueenProblem {

    private static boolean nQueen(int board[][], int size,int row){
        if(row == size-1){
            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    System.out.print(board[i][j] + ",");
                }
                System.out.println();
            }

            return true;
        }
        else {
            for(int newCol = 0; newCol < size; newCol++){
                int newRow = row + 1;
                if(isCorrectPosition(board,size,newRow,newCol)){
                    board[newRow][newCol] = 1;
                    if(nQueen(board,size,newRow)){
                        return true;
                    }
                    board[newRow][newCol] = 0;
                }

            }
            return false;
        }
    }


    private static boolean isCorrectPosition(int board[][], int size, int newRow, int newCol){
         boolean valid = true;
         // for vertical attack checking
        for(int i = 0; i < size; i++){
            if(board[i][newCol] == 1){
               valid = false;
            }
        }
        // for left diagonal
        for(int i = newRow, j = newCol; i >= 0 && j >= 0; i--, j-- ){
            if(board[i][j] == 1){
                valid = false;
            }
        }

        //for right diagonal
        for(int i = newRow, j = newCol; i >= 0 && j < size; i--, j++){
            if(board[i][j] == 1){
                valid = false;
            }
        }

        return valid;

    }
    public static void main(String[] args) {
        int board[][] = {{0,0,0,0},
                         {0,0,0,0},
                         {0,0,0,0},
                         {0,0,0,0}};

        System.out.println(nQueen(board,4,-1));
    }
}
