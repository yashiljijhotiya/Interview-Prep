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
    public static void main(String args[]){
        Spiral s = new Spiral();
        int m [][] = {{1,2,3},{4,5,6},{7,8,9}};
        s.printSpiral(m);
    }
}
