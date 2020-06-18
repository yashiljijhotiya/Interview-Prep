package design;

import java.util.HashMap;
import java.util.List;

public class TicTacToe {
    private  final int[][] board;
    private final int n;
    private final int[] rowSum, colSum;
    private int diagSum, revDiagSum;
    private int winner;

    /**
     * Makes a move on the board and return the winner if the move is winning move.
     *
     * @param  player is either 0 or 1
     * @param  row is the move in row index
     * @param col is the move in col index
     *
     * @return winner +1 if player First won the game, -1 if player Second won the game, 0 if game is Draw.
     *
     * @throws IllegalArgumentException if move is illegal move
     * */

    public TicTacToe(int n){
        this.n = n;
        board = new int[n][n];
        rowSum = new int [n];
        colSum = new int [n];

    }

    private int move(int player, int row, int col) throws  IllegalArgumentException{
        if(row < 0 || col < 0 || row >= n || col >= n){
            throw new IllegalArgumentException("Move out of board boundary");
        }
        if(board[row][col] != 0){
            throw new IllegalArgumentException("Move is already made");
        }
        if(player != 0 && player != 1){
            throw new IllegalArgumentException("Invalid Player!");
        }
        if(getWinner() != 0){
            throw new IllegalArgumentException("Invalid Playe!");
        }
        player = player == 0 ? -1 : +1;
        board[row][col] = player;
        rowSum[row] += player;
        colSum[col] += player;
        if(row == col){
            diagSum += player;
        }
        if(row == n-1-col){
            revDiagSum += player;
        }
        if(rowSum[row] == Math.abs(n) || colSum[col] == Math.abs(n) || diagSum == Math.abs(n) || revDiagSum == Math.abs(n)){
            winner =  player;
        }
        return getWinner();
    }

    private int getWinner(){
        return winner;
    }

}
