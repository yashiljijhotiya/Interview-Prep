package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithNoDuplicate {

    private static List<List<Integer>> findAllSubsets(int arr[]){
        if(arr == null || arr.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        result.add(new ArrayList<>());
        for(int i = 0; i < arr.length; i++){

        }


        return result;
    }
    public static void main(String[] args) {
        int arr[] = {1,3,3};
    }
}
