package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*Given a 2D grid, each cell is either a zombie 1 or a human 0. Zombies can turn adjacent (up/down/left/right)
* human beings into zombies every hour. Find out how many hours does it take to infect all humans?
* TC: (r*c)
* */
public class HumanToZombie {

    private static int findMinHours(int mat[][]){
        if(mat == null || mat.length == 0){
            return 0;
        }
        int human  = 0, row = mat.length, col = mat[0].length;
        int directions[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int []> queue = new LinkedList<>();

        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    human++;
                } else {
                    queue.add(new int[]{i, j});
                }
            }
        }
        return convertToZombie(mat,queue,directions,row,col,human,0);

    }

    private static int convertToZombie(int mat[][],  Queue<int []> queue, int directions[][], int row, int col, int human, int hours){

        while (!queue.isEmpty() && human > 0){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int zombie[] = queue.poll();
                for(int dir[] : directions){
                    int newX = zombie[0] + dir[0];
                    int newY = zombie[1] + dir[1];

                    if(newX >= 0 && newX < row && newY >= 0 && newY < col && mat[newX][newY] == 0){
                        mat[newX][newY] = 1;
                        queue.add(new int[] {newX, newY});
                        human--;
                    }
                }
            }
            hours++;
        }

        return human == 0 ? hours : -1;
    }

    public static void main(String[] args) {
        int mat[][] = {{0, 1, 1, 0, 1},
                       {0, 1, 0, 1, 0 },
                       {0, 0, 0, 0, 1 },
                       {0, 1, 0, 0, 0 }};
        System.out.println("min hours require to convert human to zombie are : " +findMinHours(mat));
    }
}
