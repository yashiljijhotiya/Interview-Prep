package dp.fibonacci;

import java.util.Arrays;

/*Recursive : TC: O(2^n)
* Top  down :TC : O(n^2) SC : O(n)
* */
public class MinimumJumps {

    //recursive approach
    private static int countMinJumpsRec(int arr[], int currIndex){
        //if we reach the last index, then we don't need to jump anymore
        if(currIndex == arr.length-1){
            return 0;
        }
        if(arr[currIndex] == 0){
            return Integer.MAX_VALUE;
        }
        int totalJumps = Integer.MAX_VALUE, start = currIndex + 1, end = currIndex + arr[currIndex];

        while (start < arr.length  && start < end){
            int minJumps = countMinJumpsRec(arr,start++);
            if(minJumps != Integer.MAX_VALUE){
                totalJumps = Math.min(totalJumps, minJumps +1);
            }
        }
        return totalJumps;
    }

    //Top down approach
    private static  int countMinJumpsTD(int arr[]){
        int dp[] = new int[arr.length];

        for(int i = 1; i < arr.length; i++){
            dp[i] = Integer.MAX_VALUE;
        }

        for(int start = 0; start < arr.length-1; start++){
            for(int end = start+1; end <= start + arr[start] && end < arr.length; end++){
                dp[end] = Math.min(dp[end], dp[start]+1);
            }
        }
        return dp[arr.length-1];
    }

    public static void main(String[] args) {
        int arr[] = {2,1,1,1,4};
        System.out.println(countMinJumpsTD(arr));
    }
}
