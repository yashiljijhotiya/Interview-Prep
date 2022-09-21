package sliding_window;

import java.util.HashMap;

public class ContainsDuplicateII {
    private static boolean containsDuplicate(int [] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i]) && i - map.get(arr[i]) <= k){
                return true;
            }else {
                map.put(arr[i], i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,1};
        int k = 3;
        System.out.println(containsDuplicate(arr, k));

    }
}
