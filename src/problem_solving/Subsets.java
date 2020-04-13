package problem_solving;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    private static List<List<Integer>> printAllPossibleSubsets(int arr[]){
        List<List<Integer>> subsets = new ArrayList<>();
        if(arr == null || arr.length == 0){
            return null;
        }
        //[1,2,3]  [] [1] [2] [3] [1,2] [1,3] [2,3] [1,2,3]
        double totalSubsets = Math.pow(2, arr.length);

        for(int i = 0; i < totalSubsets; i++){

        }

        subsets.add(new ArrayList<>());

        return subsets;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3};
        System.out.println(printAllPossibleSubsets(arr));
    }

}
