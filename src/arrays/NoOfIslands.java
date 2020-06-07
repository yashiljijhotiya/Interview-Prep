package arrays;
// Google, fb, amazon, calculate no of island
public class NoOfIslands {

    private int countIsland(int arr [][]){
        int totalIsland = 0;
        if(arr == null || arr.length == 0){
         return 0;
      }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] == 1){
                    totalIsland += dfs(arr,i, j);
                }
            }
        }
        return totalIsland;
    }

    private int dfs(int arr[][], int i, int j){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length || arr[i][j] == 0){
            return  0;
        }
        arr[i][j] = 0;
        dfs(arr, i+1,j);
        dfs(arr,i-1, j);
        dfs(arr,i, j+1);
        dfs(arr,i, j-1);
        return 1;
    }

    public static void main(String[] args) {
        NoOfIslands n = new NoOfIslands();
        int arr [][] = {{1,1,0,1},
                        {1,1,0,0},
                        {0,0,1,1},
                        {1,0,1,1}};
        System.out.println("Total no. of Island are :" + n.countIsland(arr));
    }
}
