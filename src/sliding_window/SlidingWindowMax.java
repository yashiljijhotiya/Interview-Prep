package sliding_window;
import java.util.ArrayDeque;
import java.util.Arrays;

/*TC : O(n)
  SC : O(k)
* */
public class SlidingWindowMax {

    private static int [] findMaxInKWindow(int arr[], int k){
        //base case
        int len = arr.length;
        if(arr == null || len == 0 || k < 0 || k > len){
            return new int[]{};
        }
        // window size is 1 return just same i/p array
        if(k == 1){
            return arr;
        }

        int result[] = new int [len-k+1];
        ArrayDeque<Integer> dQueue = new ArrayDeque<>();
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++){

            if(!dQueue.isEmpty() && dQueue.peekFirst() == windowEnd-k){
                dQueue.removeFirst();
            }
            while (!dQueue.isEmpty() && arr[dQueue.peekLast()] < arr[windowEnd]){
                dQueue.removeLast();
            }
            dQueue.offer(windowEnd);
            if(windowEnd+1 >= k){
                result[windowStart] = arr[dQueue.peekFirst()];
                windowStart++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(findMaxInKWindow(arr,3)));
    }
}
