package hashing;

import java.util.HashMap;
import java.util.HashSet;

public class MaxLenZeroSumSub {

    public int maxLen(int arr[]){
     int maxL = 0;
     int sum = 0;
        HashSet<Integer> hs = new HashSet<>();
        HashMap<Integer,Integer> h = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length;i++){
            sum += arr[i];
            if(arr[i] == 0 && maxL == 0){
                maxL =1;
            }
            if(sum == 0){
                maxL = i+1;
            }
          Integer prev = h.get(sum);
            if(prev != null){
                maxL = Math.max(maxL, i-prev);
            }
            else
                h.put(sum,i);
        }
        return maxL;
    }

    public static void main(String args[]){
        MaxLenZeroSumSub m = new MaxLenZeroSumSub();
        int arr [] = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println(" the max length of subarray with zero sum is :" + m.maxLen(arr));
     }
}
