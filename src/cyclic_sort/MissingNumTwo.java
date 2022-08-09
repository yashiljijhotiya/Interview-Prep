package cyclic_sort;

import java.util.ArrayList;
import java.util.List;

public class MissingNumTwo {
    private static List<Integer> findAllMissingNums(int [] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int i = 0, n = nums.length;
        List<Integer> res = new ArrayList<>();
        while(i < n){
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){
                swap(nums, i, j);
            }
            else {
                i++;
            }
        }
        for(int e = 0; e < n; e++){
            if(nums[e] != e+1){
                res.add(e+1);
            }
        }
        return res;
    }

    private static void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int [] nums  = {2,4,1,2};
        System.out.println(findAllMissingNums(nums));

    }
}
