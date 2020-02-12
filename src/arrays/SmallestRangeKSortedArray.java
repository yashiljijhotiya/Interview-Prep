package arrays;

import java.util.PriorityQueue;

public class SmallestRangeKSortedArray {

    private static  class Node{

        int val;
        int listNum;
        int index;

        public  Node(int val, int listNum, int index){
            this.val = val;
            this.listNum = listNum;
            this.index = index;
        }


    }
    private static int [] smallestRange(int arr[][]){
        if(arr == null || arr.length == 0)
            return null;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxRange = Integer.MIN_VALUE;
        int result [] = new int[2];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < arr.length; i++){
           pq.add(new Node(arr[i][0], i, 0 ));
           maxRange = Math.min(maxRange,arr[i][0]);
        }
        result[0] = min;
        result[1] = max;
       return result;
    }
    public static void main(String[] args) {

    }
}
