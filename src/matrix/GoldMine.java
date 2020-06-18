package matrix;
/* @author : Yashil(18-04-20)
Leetcode
TC : O(m*n)
 */
public class GoldMine {

    private static int totalGoldCollected(int mine[][]){
        if(mine == null|| mine.length == 0){
            return 0;
        }
        int m = mine.length, n = mine[0].length, maxGold = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               if(mine[i][j] != 0){
                   maxGold = Math.max(maxGold, dfs(mine,i,j));
               }
            }
        }

        return maxGold;
    }

    private static int dfs(int mine[][], int i, int j){
        if(i < 0 || j < 0 || i >= mine.length || j >= mine[0].length || mine[i][j] == 0 ){
            return 0;
        }
        int val = mine[i][j];
        mine[i][j] = 0;
        int res = Math.max(Math.max(dfs(mine,i+1,j), dfs(mine,i-1,j)),
                  Math.max(dfs(mine,i,j+1),dfs(mine,i,j-1))) + val;

        mine[i][j] = val;

     return res;
    }

    public static void main(String[] args) {
        int mine[][] = {{0,6,0},
                        {5,8,7},
                        {0,9,0}};
        System.out.println("Max gold collected is :" +totalGoldCollected(mine));
    }
}
