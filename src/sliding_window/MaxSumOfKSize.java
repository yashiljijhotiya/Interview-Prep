package sliding_window;

public class MaxSumOfKSize {

    private static int maxSum(int arr[], int k){
        if(arr == null || arr.length == 0 || k > arr.length){
            return 0;
        }
        int max = Integer.MIN_VALUE, start = 0, end, sum = 0;
        for(end = 0; end < arr.length; end++){
            sum += arr[end];

            if(end >= k - 1){
                max = Math.max(max, sum);
                sum -= arr[start];
                start++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {2,1,5,1,3,2};
        System.out.println(maxSum(arr, 3));
    }
}
