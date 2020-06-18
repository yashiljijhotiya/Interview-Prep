package matrix;

public class Transpose {

    private static void transpose(int mat[][]){
        if(mat == null || mat.length == 0){
            return;
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = i+1;  j < mat[0].length; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }

    private static void print(int mat[][]){
        if(mat.length == 0 || mat == null){
            return;
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int mat[][] = {{1,1,1},
                       {2,2,2},
                       {3,3,3}};
        transpose(mat);
        print(mat);
    }
}
