package sliding_window;

import java.util.ArrayList;
import java.util.List;

public class SLWTest {

    private static List<Double> findAverage(int arr[], int k){
        int len = arr.length;
        if(k > len){
            return null;
        }
        List<Double> result = new ArrayList<>();
        int end, start = 0;
        double avg = 0, sum = 0;
        for(end = 0; end < len; end++){
            sum += arr[end];
            if(end - start +1 == k){
                avg = sum/k;
                result.add(avg);
                sum -= arr[start];
                start++;
            }
        }
        return result;
    }

    public static double findMaxAverage(int[] nums, int k) {
        int end, start =0;
        double max = Double.MIN_VALUE;
        double sum = 0;
        for(end = 0; end < nums.length; end++){
            sum += nums[end];
            if((end - start)+1 == k){
                double avg = sum/k;
                max = Math.max(max, avg);
                sum -= nums[start++];
            }
        }
        return max;

    }


    private static List<Double> findAvg(int arr[], int k){
        List<Double> avgList = new ArrayList<>();
        int start = 0, end, sum = 0;
        double avg = 0;
        for(end = 0; end < arr.length; end++){
            sum += arr[end];
            if(end - start +1 == k){
                avg = sum/k;
                avgList.add(avg);
                sum -= arr[start++];
            }
        }
        return avgList;
    }


    public static void main(String[] args) {
        int arr[] = {1,3,2,6,-1,4,1, 8,2};
        int k = 5;
        int nums[] = {-1};
        System.out.println(findMaxAverage(nums, 1));

    }
}
