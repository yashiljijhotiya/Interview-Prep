package leetcode;

import java.util.PriorityQueue;
// T(c) : O(N*log(m)) where N is total elements and M is the size of min heap
public class SmallestKSortedRange {

    private static class Node{
        int value;
        int index;
        int arrayNo;

        public Node(int value, int index, int arrayNo){
            this.value = value;
            this.index = index;
            this.arrayNo = arrayNo;
        }
    }
    private static void findSmallestRange(int arr[][]){
        if(arr == null || arr.length == 0){
            return;
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min;

        for(int i = 0; i < arr.length; i++){
            pq.add(new Node(arr[i][0],0,i));
            max = Math.max(max,arr[i][0]);
        }

        while(true){
            Node val = pq.poll();
            min = val.value;

            if(max - min < range){
                range = max - min;
            }

            if(val.index == arr[val.arrayNo].length - 1){
                System.out.println("smallest range is : " +min + " - " + max);
                return;
            }
            pq.add(new Node(arr[val.arrayNo][val.index+1],val.index+1, val.arrayNo));
            max = Integer.max(max,arr[val.arrayNo][val.index+1]);
        }

    }
    public static void main(String[] args) {
        int arr[][] = {{3,6,8,10}, {1,5,12},{4,8,15,16},{2,6}};
        findSmallestRange(arr);

    }
}
