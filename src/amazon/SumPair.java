package amazon;

import java.util.HashMap;

public class SumPair {

    private static int[] findPair(int arr[], int target){
        int result [] = new int[2];
        if(arr == null || arr.length == 0){
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int val = target - arr[i];
            if(!map.containsKey(val)){
                map.put(arr[i], i);
            }
            else {
                result[0] = map.get(val);
                result[1] = i;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {2,7,11,15};

        int result[] = findPair(arr,9);
        System.out.println( result[0] +" -- " + result[1]);
    }
}
