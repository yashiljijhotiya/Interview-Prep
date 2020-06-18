package amazon;

import java.util.HashMap;

public class PythagorasTriplet {

    private static boolean findTriplet(int arr[]){
        if(arr == null || arr.length == 0){
            return false;
        }
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = i+1;j < n; j++){
                int sqr = arr[i]*arr[i] + arr[j] *arr[j];
                map.put(sqr, 1);
            }
        }

        for(int i = 0; i < n; i++){
            int s = arr[i]*arr[i];
            if(map.containsKey(s)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = { 9,3,1,6,10,4,8};
        System.out.println(findTriplet(arr));
    }
}
