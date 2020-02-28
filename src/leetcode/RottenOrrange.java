package leetcode;

import java.util.HashSet;

public class RottenOrrange {

    static int directions[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    private static int minTimeToRotten(int oranges[][]){
        int minutes = 0;
        HashSet<String> rotten = new HashSet<>();
        HashSet<String> fresh = new HashSet<>();
        if(oranges == null){
          return minutes;
     }
        for(int i = 0; i < oranges.length; i++){
            for(int j = 0; j <oranges[i].length; j++){
                if(oranges[i][j] == 1){
                    fresh.add("" +i + j);
                }
                else if(oranges[i][j] == 2){
                    rotten.add("" +i + j);
                }
            }
        }

        while (fresh.size() > 0){
            HashSet<String> affected = new HashSet<>();
            for(String s : rotten){
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';
                for(int [] direction : directions){
                    int nextRow = i + direction[0];
                    int nextCol = j + direction[1];
                    if(fresh.contains("" +nextRow + nextCol)){
                        fresh.remove("" +nextRow + nextCol);
                        affected.add("" +nextRow + nextCol);
                    }
                }
            }
            if(affected.size() == 0){
                return -1;
            }
            rotten = affected;
            minutes++;
        }

        return minutes;
    }
    public static void main(String[] args) {
        int oranges[][] = {{2,1,1},
                           {1,1,0},
                           {0,1,1}};
        System.out.println("min time to infect all the oranges :" + minTimeToRotten(oranges) );

    }
}
