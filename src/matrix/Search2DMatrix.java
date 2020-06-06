package matrix;
/* Leetcode,  Amazon
* TC : O(n) */
public class Search2DMatrix {

    private static boolean searchElement(int [][] mat, int target){
        if(mat == null || mat.length == 0){
            return false;
        }
        int r = 0, c = mat[0].length - 1, n = mat.length;

        while(r < n && c >= 0){
            if(mat[r][c] == target){
                return true;
            }
            else if(mat[r][c] > target){
                c--;
            }
            else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int mat[][] = {
                         {1, 4, 7, 11, 15},
                         {2, 5, 8, 12, 19},
                         {3, 6, 9, 16, 22},
                         {10, 13, 14, 17, 24},
                         {18, 21, 23, 26, 30} };
        System.out.println(searchElement(mat, 23));
    }
}
