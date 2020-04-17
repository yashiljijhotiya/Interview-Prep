package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class EqualZeroOneSubaArr {

    private static int findMaxLen(int arr[]){
        int  n = arr.length;
        int maxLen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            sum += (arr[i] == 0 ? -1 : 1);
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i- map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLen;

    }
    public static void main(String[] args) {
        int arr[] = {0,1,0,0,1,1};
        System.out.println("max len  of subarray of equal no. of 0 & 1 : " + findMaxLen(arr));
    }
}
