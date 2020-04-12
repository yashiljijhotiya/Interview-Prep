package matrix;

public class Spiral {

    public void printSpiral(int mat[][]){
        int r = mat.length;
        int c = mat[0].length;
        int k = 0;
        int l = 0;
        while(l < r && k < c){

            for(int i = l; i < c; i++){
                System.out.println(" "+ mat[k][i]);
            }
            k++;
            for(int i = k; i < r; i++){
                System.out.println(" "+ mat[i][c-1]);
            }
            c--;
            if(k < r){
                for(int i = c-1; i >= l; i--){
                    System.out.println(" "+ mat[r-1][i]);
                }
               r--;
            }
            if(l < c){
                for(int i = r-1; i >= k; i--){
                    System.out.println(" "+ mat[i][l]);
                }
                l++;

            }

        }
    }

    private static void printMatrix(int mat[][]){
        if(mat == null || mat.length == 0){
            return;
        }
        int row = mat.length;
        int col = mat[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(mat[i][j] + ",");
            }
            System.out.println();
        }
    }

    private static void printSpiralMatrix(int mat[][]){
        if(mat == null || mat.length == 0){
            return;
        }
        int top = 0, bottom = mat.length - 1, left = 0, right = mat[0].length - 1;
        int dir = 1;

        while(top <= bottom && left <= right){
            if(dir == 1) {
                for (int i = left; i <= right; i++) {
                    System.out.print(mat[top][i] + " ");
                }
                top++;
                dir = 2;
                System.out.println();
            }
            else if(dir == 2) {
                for (int i = top; i <= bottom; i++) {
                    System.out.print(mat[i][right] + " ");
                }
                right--;
                dir = 3;
                System.out.println();
            }
            else if(dir == 3) {
                for (int i = right; i >= left; i--) {
                    System.out.print(mat[bottom][i] + " ");
                }
                bottom--;
                dir = 4;
                System.out.println();
            }
            else if(dir == 4) {
                for (int i = bottom; i >= top; i--) {
                    System.out.print(mat[i][left]);
                }
                left++;
                dir = 1;
                System.out.println();
            }
        }
    }

    public static void main(String args[]){
        Spiral s = new Spiral();
        int m [][] = {{1,2,3,4},
                      {5,6,7,8},
                      {9,10,11,12}};
        //s.printSpiral(m);
        printSpiralMatrix(m);
    }
}
