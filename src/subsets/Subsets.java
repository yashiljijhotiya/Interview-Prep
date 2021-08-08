package subsets;

import java.util.ArrayList;
import java.util.List;
//TC : O(n*2^n)
//SC : O(n*2^n)
public class Subsets {

    private static List<List<Integer>> findAllSubsets(int arr[]){
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int i : arr){
            int n = result.size();
            for(int j = 0; j < n; j++){
                List<Integer> subSet = new ArrayList<>(result.get(j));
                subSet.add(i);
                result.add(subSet);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(findAllSubsets(arr));
    }
}
