package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    private static List<List<Integer>> printAllSubSet(int num[]){
        List<List<Integer>> subsets = new ArrayList<>();
        if(num == null || num.length == 0){
            System.out.println("No subset possible");
            return null;
        }

        generateSubsets(0, num, new ArrayList<Integer>(), subsets);

      return subsets;
    }

    private static void generateSubsets(int index, int num[], List<Integer> curr, List<List<Integer>> subsets){
      subsets.add(new ArrayList<>(curr));
      for(int i = index; i < num.length; i++){
          curr.add(num[i]);
          generateSubsets(index+1, num, curr,subsets);
          curr.remove(curr.size()-1);
      }
    }
    public static void main(String[] args) {
        int num [] = {1,2,3};
        System.out.println(printAllSubSet(num));


    }
}
