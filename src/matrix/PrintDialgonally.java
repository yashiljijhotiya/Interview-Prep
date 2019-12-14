package matrix;

public class PrintDialgonally {

    private static  void printDiagonally(int mat[][]){
        int c = mat[0].length;
        for(int i = 0 ; i < c; i++){
                if(i == 0) {
                    System.out.println("[" + mat[0][i] + "]");
                }
                if(i != 0){
                    System.out.print("[" + mat[0][i] + ",");
                }

            for(int j = i-1; j >= 0; j--){
                System.out.print( + mat[i][j] + "]");
            }
        }
    }

    public static void main(String[] args) {
        int arr[][] = {{1,2,3},
                       {4,5,6},
                       {7,8,9}};
        printDiagonally(arr);
    }
}
