package sliding_window;
/* smallest window sum greater or equal to given sum
*@author Yashil (14-04-20)
*TC: O(n)
* */
public class SmallestSubArraySum {

    private static int smallestWindowSum(int arr[], int val){
        int windowSize = Integer.MAX_VALUE, left = 0, right, sum = 0;

        if(arr.length == 0 || arr == null){
            return 0;
        }

        for(right = 0; right < arr.length; right++){
            sum += arr[right];

            while(sum >= val){
                windowSize = Math.min(windowSize, right-left+1);
                sum = sum - arr[left];
                left++;
            }
        }

        return windowSize;
    }

    public static void main(String[] args) {
        int arr[] = {2,1,5,2,3,7};
        int val = 7;
        System.out.println("min window size for sum  "+val + " is : "+smallestWindowSum(arr,val));
    }
}
