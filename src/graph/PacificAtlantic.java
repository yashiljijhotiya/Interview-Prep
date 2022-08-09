package graph;

import java.util.ArrayList;
import java.util.List;
/**
        * Leetcode: 417
        * */
public class PacificAtlantic {
    private static List<List<Integer>> findFloodedIsland(int islands[][]){
        List<List<Integer>> result = new ArrayList<>();
        if(islands == null || islands.length == 0){
            return result;
        }
        int row = islands.length, col = islands[0].length;
        boolean pacific [][] = new boolean[row][col];
        boolean atlantic[][] = new boolean[row][col];
        /** Horizontal side surrounded ocean */
        for(int i = 0; i < col; i++){
            dfs(islands,0, i, Integer.MIN_VALUE, pacific);
            dfs(islands,row-1, i, Integer.MIN_VALUE, atlantic);
        }
        /** Vertical side surrounded ocean */
        for(int i = 0; i < row; i++){
            dfs(islands, i,0, Integer.MIN_VALUE, pacific);
            dfs(islands, i,col-1, Integer.MIN_VALUE, atlantic);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.add(j);
                }
            }
        }
        return result;
    }

    private static void dfs(int islands[][],int row, int col, int prev, boolean ocean [][]){
        if(row < 0 || col < 0 || row > islands.length || col > islands[0].length || islands[row][col] < prev || ocean[row][col] == true){
            return;
        }
        ocean[row][col] = true;
        dfs(islands,row+1, col, islands[row][col], ocean);
        dfs(islands,row-1, col, islands[row][col], ocean);
        dfs(islands,row, col+1, islands[row][col], ocean);
        dfs(islands,row, col-1, islands[row][col], ocean);
    }

    public static void main(String[] args) {
        int [][] islands = {{1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}};

        System.out.println(findFloodedIsland(islands).toString());

    }
}
