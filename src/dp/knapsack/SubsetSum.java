package dp.knapsack;

/* considering only for positive values
 *
 * */
public class SubsetSum {

    private static boolean subsetRec(int arr[], int val, int n) {
        if (val == 0) {
            return true;
        }
        if (n < 0 || val < 0) {
            return false;
        }
        if (arr[n] > val) {
            return subsetRec(arr, val, n - 1);
        }
        return subsetRec(arr, val - arr[n], n - 1) || subsetRec(arr, val, n - 1);
    }

    private static boolean subsetMemoize(int arr[], int val, int n, Boolean dp[][]){
        if(val <= 0 || n == 0){
            return val == 0;
        }
        if(dp[n][val] != null){
            return dp[n][val];
        }
        int index = n-1;
        if(arr[index] > val){
            dp[n][val] = subsetMemoize(arr,val,n-1,dp);
        }
        else {
            boolean includingVal = subsetMemoize(arr, val-arr[index],n-1, dp);
            boolean notIncludingVal = subsetMemoize(arr, val, n-1, dp);
            dp[n][val] = includingVal || notIncludingVal;
        }
        return dp[n][val];
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 11, 22, 9, 4};
        int sum = 15;
        int n = arr.length-1;
        System.out.println("Is subset is present : " + subsetRec(arr, sum, n));
        boolean dp[][] = new boolean[n+2][sum+1];

    }
}
