package amazon;
/*Leetcode # 560
* */
import java.util.HashMap;

public class SubArraySum {

    private static int findAllSubArrays(int arr[], int x){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            currSum += arr[i];
            if(currSum == x){
                count++;
            }
            if(map.containsKey(currSum - x)){
                count++;
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return count;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,7,2,-3,1,4,2};
        System.out.println(findAllSubArrays(arr,7));

    }
}
