package mathematics;
/*case 1 : [1,-2,(3,4),-2] max sum lies in mid of arr
*case 2 : [5),-3,(4] max sum is total - min sum
*case 3 : [-2,-3,(-1] max will be the max of all arr
* */
public class MaxSumCircularArr {

    private static int maxSum(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int curr1 = 0, curr2 = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, total = 0;
        for(int i = 0; i < arr.length; i++){
            //Max sum
            curr1 += arr[i];
            max = Math.max(max,curr1);
            curr1 = Math.max(curr1,0);
            // Min sum
            curr2 += arr[i];
            min = Math.min(min, curr2);
            curr2 = Math.min(curr2,0);
            // total sum
            total += arr[i];
        }
        return max < 0 ? max : Math.max(max, total - min);
    }
    public static void main(String[] args) {
        int arr[] = {5,-3,-2,6,-1,4};
        System.out.println(maxSum(arr));
    }
}
