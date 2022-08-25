package dp.lis;

public class LIS {
    private static int LIS(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        return LISRec(arr, -1, 0, n);
    }

    private static int LISRec(int [] arr, int prevIndex, int currIndex, int n){
        if(currIndex == n){
            return 0;
        }
        int len = 0 + LISRec(arr, prevIndex, currIndex+1, n);
        if(prevIndex == -1 || arr[currIndex] > arr[prevIndex]){
            len = Math.max(len, 1 + LISRec(arr, currIndex, currIndex+1, n));
        }
        return len;
    }

    private static int maxIncreasingSubsequence(int arr[], int prev, int curr, int n){
        if(curr == n){
            return 0;
        }
        int sum = 0 + maxIncreasingSubsequence(arr, prev, curr+1, n);
        if(prev == -1 || arr[curr] > arr[prev]){
            sum = Math.max(sum, arr[curr] + maxIncreasingSubsequence(arr,curr,curr+1, n));
        }
        return sum;
    }
    public static void main(String[] args) {
        int arr[] = {4,2,3,6,10,1,12};
      //  System.out.println(LIS(arr));
        int ar[] = {4,1,2,6,10,1,12};
        System.out.println(maxIncreasingSubsequence(ar, -1, 0, ar.length));

    }
}
