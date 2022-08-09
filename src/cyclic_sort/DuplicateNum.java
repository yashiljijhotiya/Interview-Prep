package cyclic_sort;

public class DuplicateNum {

    private static void findAllDuplicateNums(int [] nums){
        if(nums == null || nums.length ==0){
            return;
        }
        int i = 0, n = nums.length;
        while (i < n){
            int j = nums[i] - 1;
            if(nums[i] != nums[j]){
                swap(nums, i, j);
            }else {
                i++;
            }
        }
        for(int e = 0; e < n; e++){
            if(nums[e] != e+1){
                System.out.println(nums[e]);
            }
        }
    }

    private static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        int [] nums = {3,4,4,2,2,5,5};
        findAllDuplicateNums(nums);

    }
}
