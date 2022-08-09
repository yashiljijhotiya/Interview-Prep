package cyclic_sort;

public class MissingNum {
    private static int findMissingNum(int [] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int i = 0, n = nums.length;
        while(i < n){
            int j = nums[i];
            if(nums[i] < n && nums[i] != nums[j]){
                swap(nums,i,j);
            }else {
                i++;
            }
        }
        for(int e = 0; e < n; e++){
            if(nums[e] != e){
                return e;
            }
        }
        return n;
    }
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int [] nums = {4,0,3,1};
        System.out.println(findMissingNum(nums));
    }
}
