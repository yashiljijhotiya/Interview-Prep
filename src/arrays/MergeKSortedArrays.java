package arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArrays {
//TC : (n)*log(k)
    private static class PQNode{
        int arrayNum;
        int index;
        int val;
        public PQNode(int arrayNum, int index, int val){
            this.arrayNum = arrayNum;
            this.index = index;
            this.val = val;
        }
}
    private static void mergeKSortedArray(int arr[][]){
        if(arr == null || arr.length == 0)
            return;
        int size = 0;
        PriorityQueue<PQNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < arr.length; i++){
            size += arr[i].length;
            minHeap.add(new PQNode(i,0,arr[i][0]));
        }

//        int sortedArr[] = new  int[size];
//        for (int i = 0; i < size; i++){
//            PQNode node = minHeap.poll();
//            if(node != null){
//                sortedArr[i] = node.val;
//                if(node.index+1 < arr[node.arrayNum].length){
//                    minHeap.add(new PQNode(node.arrayNum,node.index+1, arr[node.arrayNum][node.index+1]));
//                }
//            }
//        }
//        for (int i = 0; i < size; i++){
//            System.out.println(sortedArr[i]);
//        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()){
            PQNode node = minHeap.poll();
            result.add(node.val);
            if(node.index+1 < arr[node.arrayNum].length){
                minHeap.add(new PQNode(node.arrayNum, node.index+1, arr[node.arrayNum][node.index+1]));
            }
        }
    result.forEach(i -> System.out.println(i));
    }

    public static void main(String[] args) {
       int arr[][] = {{1,2,3,5},
                      {7,11,13},
                      {4,6,9}};
       mergeKSortedArray(arr);

    }
}
