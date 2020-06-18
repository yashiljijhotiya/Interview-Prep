package matrix;

public class MaxNoOfOne {

    private static  int findRowWithMaxOne(int mat[][]){
        int result = 0;
        int r = mat.length;
        int c = mat[0].length;
        int j = first(mat, 0, c-1);
        if(j == -1)
             j = c-1;
        for(int i = 1; i < r; i++){
            while(j >=0 && mat[i][j] == 1){
                j--;
                result = i;
            }
        }

        return  result;
    }

    private static  int first(int mat[][], int r, int c){
        int res = -1;
        while(c >= 0){
            if(mat[r][c] == 0){
                res = c;
                break;
            }
            c--;
        }
        return  res;
    }

    public static void main(String[] args) {
        int mat [][] = {{0,1,1,1},
                {0,0,0,1},
                {0,0,1,1},
                {1,1,1,1}};
        System.out.println(" Row with max no. of 1 is : " +findRowWithMaxOne(mat));
    }
}
