package matrix;

import java.util.ArrayList;
import java.util.List;

// Leetcode  : Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class SetZero {

    private static void setZero(int mat[][]){

        if(mat == null || mat.length == 0) {
            return;
        }
        List<Integer> rowIndex = new ArrayList<>();
        List<Integer> colIndex = new ArrayList<>();
        int m = mat.length, n = mat[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    rowIndex.add(i);
                    colIndex.add(j);
                }
            }
        }

        for(int row : rowIndex){
            for(int i = 0; i < mat[row].length; i++){
                mat[row][i] = 0;
            }
        }

        for(int col : colIndex){
            for(int i = 0; i < mat.length; i++){
                mat[i][col] = 0;
            }
        }

    }

    private static void print(int mat[][]){
        for(int i =0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1,1,1},{1,0,1},{1,1,1}};
        setZero(mat);
        print(mat);

    }
}
