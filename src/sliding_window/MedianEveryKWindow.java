package sliding_window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
/*LeetCode
* TC : = O(2*n*log(k)) + O(n-k) = O(n*log(k))
* */
public class MedianEveryKWindow {

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    private static List<Double> findMedian(int arr[], int k){
        if(arr.length == 0 || arr == null || k < 0 || k > arr.length){
            return new ArrayList<>();
        }
        List<Double> result = new ArrayList<>();
        int windowEnd, windowStart = 0;
        double median;
        for(windowEnd = 0; windowEnd < arr.length; windowEnd++){
            insert(arr[windowEnd]);
            if(minHeap.size() + maxHeap.size() >= k){
                if(minHeap.size() == maxHeap.size()){
                    median = minHeap.peek()/2+maxHeap.peek()/2;
                }
                else {
                    median = maxHeap.peek();
                }
                result.add(median);
                remove(arr[windowStart]);
                windowStart++;
            }
        }
        return result;
    }

    private static void insert(int val){
        if(maxHeap.isEmpty() || maxHeap.peek() >= val){
            maxHeap.offer(val);
        }
        else {
            minHeap.offer(val);
        }

        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    private static void remove(int val){
        if(!maxHeap.remove(val)){
            minHeap.remove(val);
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        System.out.println(findMedian(arr,3));

    }
}
