package arrays;

import java.util.PriorityQueue;

public class LargestElement {
    int elem;
    private int getElementt(int arr[], int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr){
            pq.add(arr[i]);
        }
        for(int i = 0; i <= n; i++){
            if(i == n-1){
             elem = pq.remove();
            }
        }
        return elem;
    }

    public static void main(String[] args) {
        LargestElement l = new LargestElement();
        int arr[] = {8,3,11,19,6,21,4};
        System.out.print(" 3 smallest elem"+ l.getElementt(arr,2));

    }
}
