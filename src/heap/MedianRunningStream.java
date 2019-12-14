package heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianRunningStream {

    private static double[] getMedians(int arr[]) {
        //max heap using custom comparator
//        PriorityQueue<Integer> max_heap = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -1 * o1.compareTo(o2);
//            }
//        });
        double [] medians = new  double[arr.length];
        PriorityQueue<Integer> lower_heap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> upper_heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
         int number = arr[i];
         addNumber(number, lower_heap,upper_heap);
         rebalanceHeap(lower_heap, upper_heap);
         medians[i] = getMedian(lower_heap,upper_heap);
        }

        return medians;
    }

    private  static void addNumber(int num, PriorityQueue<Integer> lower, PriorityQueue<Integer> upper){
        if(lower.size() == 0 || lower.peek() > num){
            lower.add(num);
        }
        else {
            upper.add(num);
        }
    }

    private static  void rebalanceHeap(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper){

    }

    private static double getMedian(PriorityQueue<Integer> lower, PriorityQueue<Integer> upper){
        double median = 0;

        return median;
    }
    public static void main(String[] args) {
      int arr[] = {9,3,2,15,4,11,19,65,33,21,1};
        System.out.println(getMedians(arr));
    }
}
