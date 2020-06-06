package sliding_window;

import java.util.Arrays;

public class AvgSubArrayKSize {

    private static String findAvg(int arr[], int k){
        double [] result = new double[arr.length - k + 1];
        double sum = 0;
        int start = 0,  end;
        for(end = 0; end < arr.length; end++){
            sum += arr[end];

            if(end  >= k - 1){
                result[start] = sum/k;
                sum -= arr[start];
                start++;
            }
        }

        return Arrays.toString(result);
    }
    public static void main(String[] args) {
        int [] arr = {1,3,2,6,-1,4,1,8,2};
        System.out.println(findAvg(arr,5));
    }
}
