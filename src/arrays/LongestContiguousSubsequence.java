package arrays;

import java.util.HashSet;
import java.util.Iterator;

public class LongestContiguousSubsequence {

    private static int longestSubsequence(int arr[]){
        int maxLen = 0;
        int start;
        int end;
        int count = 1;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(!hs.contains(arr[i])){
                hs.add(arr[i]);
            }
        }
        //Iterator<>
        for(int num : hs){
            if(hs.contains(num-1)){
               start = num;
               while(hs.contains(start+1)){
                   count++;
                   start++;
               }
               maxLen = Math.max(maxLen,count);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int arr[] = {2,1,6,9,4,3,7,5};
        System.out.println("longest subsequence length is :" + longestSubsequence(arr) );
    }
}
