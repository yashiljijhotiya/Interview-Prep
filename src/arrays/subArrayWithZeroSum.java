package arrays;

import java.util.HashMap;

public class subArrayWithZeroSum {
// Either sum repeats or sum becomes zero.
    private static  boolean isZeroSumSubArray(int arr[]){
        int sum = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
           sum += arr[i];
           if(sum == 0 || map.containsKey(sum)){
               return true;
           }
           else{
               map.put(sum, true);
           }
        }
        return false;
    }

    private static  int maxLenOfSubArrWithZeroSum(int arr[]){
        int max_len = 0;
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }

        return max_len;
    }
    public static void main(String[] args) {
        int arr [] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(isZeroSumSubArray(arr) ? "array contains subarray with zero sum" : "No subarray with zero sum");
    }
}
