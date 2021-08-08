package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianRunningStream {

    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);

   private static int findMedian(){
       if(maxHeap.size() == minHeap.size()){
           return (maxHeap.peek() + minHeap.peek())/2;
       }else {
           return maxHeap.peek();
       }
   }

   private static void addElement(int num){
       if(maxHeap.isEmpty() || maxHeap.peek() >= num){
           maxHeap.add(num);
       }
       else {
           minHeap.add(num);
       }
//either both heap have equal no. of elements of maxHeap have one element more
       if(maxHeap.size() > minHeap.size() + 1){
           minHeap.add(maxHeap.poll());
       }
       else if(maxHeap.size() < minHeap.size()){
           maxHeap.add(minHeap.poll());
       }

   }
    public static void main(String[] args) {
       addElement(3);
       addElement(5);
       System.out.println("median is : "+ findMedian());
       addElement(1);
       System.out.println("median is : "+ findMedian());
    }
}
