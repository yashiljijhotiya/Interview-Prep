package leetcode;

import java.util.ArrayList;
import java.util.List;
// TC : O(2^n)
public class Subsets {
    private static List<List<Integer>> printAllSubSet(int num[]){
        List<List<Integer>> subsets = new ArrayList<>();
        if(num == null || num.length == 0){
            System.out.println("No subset possible");
            return null;
        }
        subsets.add(new ArrayList<>());
        for(int currentNum : num){
            int n = subsets.size();
            for(int i = 0; i < n; i++){
              List<Integer> set = new ArrayList<>(subsets.get(i));
              set.add(currentNum);
              subsets.add(set);
            }
        }

      return subsets;
    }
    public static void main(String[] args) {
        int num [] = {1,2,3};
        System.out.println(printAllSubSet(num));


    }
}
