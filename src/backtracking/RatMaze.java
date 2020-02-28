package backtracking;

public class RatMaze {

    static int pathRow [] = {};
    static int pathCol [] = {};
    private  static  void  findPathOnMaze(int maze[][], boolean visited[][], int row, int col, int desRow, int desCol, int move){
        if(row == desRow && col == desCol){
            for(int i = 0; i < maze.length; i++){
                for(int j = 0; j < maze[0].length; j++){
                    System.out.println(maze[i][j] + ", ");
                }
                System.out.println();
            }
            System.out.println();
        }

        for(int i = 0; i < pathRow.length; i++){
            int newRow = row + pathRow[i];
            int newCol = col + pathCol[i];
            if(isValidPath(maze,visited,newRow,newCol,move)){
                move++;
                visited[newRow][newCol] = true;
                findPathOnMaze(maze,visited,row,col,desRow,desCol,move);
                visited[newRow][newCol] = false;
            }
        }
    }

    private static boolean isValidPath(int maze[][], boolean visited[][], int newRow, int newCol, int move){
        if(newRow > maze.length || newCol > maze.length || newCol < 0 || newRow < 0 || !visited[newRow][newCol]){
            return false;
        }
        else {
            return true;
        }
    }
    public static void main(String[] args) {

    }
}
