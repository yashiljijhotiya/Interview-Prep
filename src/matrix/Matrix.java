package matrix;

public class Matrix {
    public void hourGlass(int arr[][]){
        int r = arr.length;
        int c = arr[0].length;
        int temp1;
        int temp2;
        System.out.println("rows: "+r);
        System.out.println("column: "+c);
        for(int i = 0; i < r; i++){
            temp1 = arr[i][i];
        }
        //for(int)
    }
    public static void main(String args[]){
        Matrix m = new Matrix();
        int arr[][] = {{1,2,3},
                     {4,5,6},
                     {7,8,9}};
        m.hourGlass(arr);
    }
}
