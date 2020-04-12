package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElem {


    private int getKLargest(int arr[], int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//5,7, 9,11
        // k = 2

        for(int i : arr){
            minHeap.add(i);
            if(minHeap.size() > k){
                minHeap.remove();
            }
        }
        return  minHeap.remove();
    }


    private static void printKthSmallest(int arr[], int k){
        if(arr == null || arr.length == 0 || k > arr.length){
            return;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : arr){
            maxHeap.add(i);
            if(maxHeap.size() > k){
                maxHeap.remove();
            }
        }
        System.out.printf(k+"th smallest element is :" + maxHeap.remove());
    }

    private static  int count(int arr[], int k){
        int maxLen3 = 0, maxLen5 = 0, count3 = 0, count5 = 0;
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            if(arr[i] == 3){
                count3++;
                if(maxLen3 < count3){
                   maxLen3 = count3;
                }
                count5 = 0;
            }
            else {
                count5++;
                if (maxLen5 < count5) {
                    maxLen5 = count5;
                }
                count3 = 0;
            }
        }
        result = Integer.max(maxLen3, maxLen5) + k;
        return result;
    }

    private static void countAlphabet(int arr[], int time){
        int min = Integer.MAX_VALUE;
        int index = 0;
       // int lenOfString = 0;
        for(int i = 0; i < arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
                index = i;
            }
        }
        var lenOfString = time/min;
        System.out.println("length of string is : " + lenOfString);
        for(int i = 0; i < lenOfString; i++){
            System.out.print((char)(index+ 1 + 96));
        }
        System.out.println();
    }
    public static void main(String[] args) {

        KLargestElem l = new KLargestElem();
        int arr[] = {3,2,3,1,2,4,5,5,6};
         //int arr [] = {3,3,5,3,3,5,3,3};
         //int k = 1;
        //System.out.println(count(arr,k));
       // System.out.println("Kth largest elem is : " + l.getKLargest(arr, 2));
        //int arr[] = {2, 1, 2, 1, 2, 1, 3, 4, 5, 2, 1, 2, 1, 9, 8, 5, 3, 3, 3, 4, 6, 7, 10, 11, 6, 9};
        //countAlphabet(arr,10);
        printKthSmallest(arr,5);
    }
}
