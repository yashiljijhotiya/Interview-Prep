package sliding_window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
/* Remove from front & add at rear of dequeue
* Dequeue always contains element in desc order
*Storing index in dequeue provide random access
* */
public class MaxOfEveryKWindow {

    private static void maxInKSizeWindow(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return;

        int[] output = new int[arr.length - k + 1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            /* Whenever we move to a new window, discard previous window */
            if (!ad.isEmpty() && ad.peekFirst() == i - k) {
                ad.removeFirst();
            }

            /* If element pointed by current index is greater than elements pointed by previous index,
            discard previous indexes */
            while (!ad.isEmpty() && arr[ad.peekLast()] < arr[i]) {
                ad.removeLast();
            }

            /* Add the new index to the end of the ArrayDeque */
            ad.offer(i);


            /* When we find new window, we ll add the maximum in the window to the output */
            if (i + 1 >= k) {
                output[i + 1 - k] = arr[ad.peekFirst()];
            }
        }
        System.out.println(Arrays.toString(output));
    }


    public static void main(String[] args) {
     int arr[] = {12, 1, 78, 90, 57, 89, 56 };
     maxInKSizeWindow(arr,3);
    }
}
