package leetcode;
import java.util.LinkedList;
import java.util.Queue;

public class    RottenOrrange {

//    static int directions[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
//    private static int minTimeToRotten(int oranges[][]){
//        int minutes = 0;
//        HashSet<String> rotten = new HashSet<>();
//        HashSet<String> fresh = new HashSet<>();
//        if(oranges == null){
//          return minutes;
//     }
//        for(int i = 0; i < oranges.length; i++){
//            for(int j = 0; j <oranges[i].length; j++){
//                if(oranges[i][j] == 1){
//                    fresh.add("" +i + j);
//                }
//                else if(oranges[i][j] == 2){
//                    rotten.add("" +i + j);
//                }
//            }
//        }
//
//        while (fresh.size() > 0){
//            HashSet<String> affected = new HashSet<>();
//            for(String s : rotten){
//                int i = s.charAt(0) - '0';
//                int j = s.charAt(1) - '0';
//                for(int [] direction : directions){
//                    int nextRow = i + direction[0];
//                    int nextCol = j + direction[1];
//                    if(fresh.contains("" +nextRow + nextCol)){
//                        fresh.remove("" +nextRow + nextCol);
//                        affected.add("" +nextRow + nextCol);
//                    }
//                }
//            }
//            if(affected.size() == 0){
//                return -1;
//            }
//            rotten = affected;
//            minutes++;
//        }
//
//        return minutes;
//    }
//
    private static int minTimeToRotten(int oranges[][]){
        if(oranges == null || oranges.length == 0){
            return 0;
        }
        int directions[][] = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        int time, fresh = 0, row = oranges.length, col = oranges[0].length;
        Queue<int []> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(oranges[i][j] == 1){
                    fresh++;
                }
                else if(oranges[i][j] == 2){
                    queue.add(new int []{i,j});
                }
            }
        }
        time = timeToRotten(oranges,directions, queue,row,col,fresh);
        return time;
    }

    private static int timeToRotten(int [][] oranges, int [][] directions, Queue<int []> queue, int row, int col, int fresh){
        int time = 0;

        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int rotten[] = queue.poll();
                for(int dir[] : directions){
                    int newX = rotten[0] + dir[0];
                    int newY = rotten[1] + dir[1];
                    if(newX >= 0 && newX < row && newY >= 0 && newY < col && oranges[newX][newY] == 1){
                        oranges[newX][newY] = 2;
                        queue.add(new int [] {newX, newY});
                        fresh--;
                    }
                }
            }
            time++;
        }

        return fresh == 0 ? time : -1;
    }
    public static void main(String[] args) {
        int oranges[][] = {{2,1,1},
                           {0,1,0},
                           {1,0,1}};
        System.out.println("min time to infect all the oranges :" + minTimeToRotten(oranges) );

    }
}
