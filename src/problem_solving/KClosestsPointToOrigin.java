package problem_solving;

import java.util.PriorityQueue;
//√{(x2-x1)2 + (y2-y1)2}
public class KClosestsPointToOrigin {

    private static void printKClosests(int arr[][], int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (b[0]* b[0] + b[1] * b[1] - (a[0]*a[0] + a[1]*a[1])));
        for(int [] a : arr){
            pq.add(a);
            if(pq.size() > k){
               pq.remove();
            }
        }

    }
    public static void main(String[] args) {

    }
}
