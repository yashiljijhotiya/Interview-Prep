package dp.paint_problem;

public class PaintHouseTwo {

    private static int findCost(int arr[][]){
        int house = arr.length;
        int color = arr[0].length;
        int dp[][] = new int [house][color];
        /** color first row houses */
        for(int i = 0; i < color; i++){
            dp[0][i] = arr[0][i];
        }
        for(int i = 1; i < house; i++){
           // for ()
        }

        return 0;
    }

    public static void main(String[] args) {
        int arr[][] = {};
    }
}
