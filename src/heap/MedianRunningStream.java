package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianRunningStream {



   private static int getMedian(int num){
       int median = 0;
       PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> a - b);
       PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

       if(maxHeap.isEmpty() || maxHeap.peek() > num){
           maxHeap.add(num);
       }
       else {
           minHeap.add(num);
       }

       if(maxHeap.size() > minHeap.size() + 1){
           minHeap.add(maxHeap.poll());
       }

       return median;
   }
    public static void main(String[] args) {

    }
}
