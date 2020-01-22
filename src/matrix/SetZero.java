package matrix;
// Leetcode  : Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
public class SetZero {

    private static void setZero(int mat[][]){

        if(mat == null || mat.length == 0)
            return;
        boolean rowFlag = false, columnFlag = false;
        int r = mat.length;
        int c = mat[0].length;

        //setting rowFlag
        for(int i = 0; i < r; i++){
            if(mat[0][i] == 0){
                rowFlag = true;
            }
        }

        //setting col flag
        for(int i = 0; i < c; i++){
            if(mat[i][0] == 0){
                columnFlag = true;
            }
        }
    }
    public static void main(String[] args) {

    }
}
