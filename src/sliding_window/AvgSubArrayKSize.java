package sliding_window;

import java.util.Arrays;

public class AvgSubArrayKSize {

    private static String findAvg(int arr[], int k){
        double [] result = new double[arr.length - k + 1];
        double sum = 0;
        int windowStart = 0,  windowEnd;
        for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
            sum += arr[windowEnd];

            if(windowEnd+1  >= k){
                result[windowStart] = sum/k;
                sum -= arr[windowStart];
                windowStart++;
            }
        }

        return Arrays.toString(result);
    }
    public static void main(String[] args) {
        int [] arr = {1,3,2,6,-1,4,1,8,2};
        System.out.println(findAvg(arr,3));
    }
}
