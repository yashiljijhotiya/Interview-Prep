package arrays;

import java.util.HashMap;

public class CountSumPairs {

    private static int countNoOfPairs(int arr[], int sum){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],0);
            }
            else{
                map.put(arr[i], map.get(arr[i]) + 1);
            }

        }
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(sum-arr[i])){

                result++;
            }
        }
        return  result;
    }
    public static void main(String[] args) {
        int arr [] = {7,1,11,19, 5,4,3,6};
        System.out.println("no. of pairs are : " +countNoOfPairs(arr, 10));
    }
}
