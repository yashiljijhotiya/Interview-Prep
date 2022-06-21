package matrix;
// Total no. of hour glass formed will be equal to (row-2)*(col-2)
//TC: O(r*c)
public class HourGlass {

    private static int maxHourGlassSum(int mat[][]){
        if(mat == null || mat.length < 3 || mat[0].length < 3){
            return -1;
        }
        int row = mat.length, col = mat[0].length;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < row-2; i++){
            for(int j = 0; j < col-2; j++){
                int sum = mat[i][j]+ mat[i][j+1]+mat[i][j+2]+
                          mat[i+1][j+1]+
                          mat[i+2][j]+mat[i+2][j+1]+mat[i+2][j+2];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int mat[][] = {{9, -9, -9,  1, 1, 1},
                       {0, -9,  0,  4, 3, 2},
                       {-9, -9, -9,  1, 2, 3},
                       { 0,  0,  8,  6, 6, 0},
                       {0,  0,  0, -2, 0, 0},
                       {0,  0,  1,  2, 4, 0}};
        System.out.println("max hour glass sum is : "+ maxHourGlassSum(mat));

    }
}
