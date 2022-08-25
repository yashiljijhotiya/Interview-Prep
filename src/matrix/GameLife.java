package matrix;

/**
 * Leetcode: 289
 * TC: O(m*n)
 **/
public class GameLife {
    private static int[][] directions = {};

    private static void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int countLiveNbr = 0;
                for (int[] dir : directions) {
                    int x = dir[0] + i;
                    int y = dir[1] + j;
                    if (isValidNeighbour(board, r, c, x, y) && Math.abs(board[x][y]) == 1) {
                        countLiveNbr++;
                    }
                }
                if (board[i][j] == 1 && (countLiveNbr < 2 || countLiveNbr > 3)) {
                    board[i][j] = -1;
                }
                if (board[i][j] == 0 && countLiveNbr == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] >= 1) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }

    }

    private static boolean isValidNeighbour(int[][] board, int r, int c, int x, int y) {
        return (x >= 0 && x < r && y >= 0 && y < c);
    }

    public static void main(String[] args) {

    }
}
