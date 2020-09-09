package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArr {

    private static List<Integer> merge(int arr[][]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for(int [] i : arr){
            for(int j : i){
                pq.offer(j);
            }
        }
        while (!pq.isEmpty()){
            result.add(pq.poll());
        }
        return result;
    }


  public static void main(String[] args) {

      int arr[][] = {{3,7,11}, {2,21,23}, {5,7}};
      System.out.println(merge(arr));
    //
  }
}
