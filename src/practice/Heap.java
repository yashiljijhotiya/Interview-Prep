package practice;

import java.util.Collections;
import java.util.PriorityQueue;

public class Heap {

    private static int kLargestElement(int arr[], int k){
        if(arr == null || arr.length == 0 || k > arr.length || k == 0){
            return -1;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : arr){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    private static int findKSmallestElement(int arr[], int k){
        if(arr == null || arr.length == 0 || k == 0 || k > arr.length){
            return -1;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            maxHeap.add(i);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.poll();
    }

    private static int findIndex(int arr[], int key){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int start = 0, end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,1,5,12,2,11};
        int k = 2;
        //System.out.println(k+" th largest element is : " + kLargestElement(arr, k));
        System.out.println(k+" th smallest element is : " + findKSmallestElement(arr, k));
    }
}
