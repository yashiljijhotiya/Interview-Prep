package dp.knapsack;

public class SubsetSum {

    private static boolean subsetRec(int arr[], int val, int n){
        if(arr.length == 0 || arr == null){
            return false;
        }
        if(arr[n] <= val){
            return subsetRec(arr,val-arr[n], n-1);
        }

        return subsetRec(arr,val, n-1);
    }

    public static void main(String[] args) {

    }
}
