package arrays;

import java.util.ArrayList;
import java.util.PriorityQueue;
// TC :- O(nLog k)
public class MergeKSortedArray {

    private static  void sortKSortedArr(ArrayList<Integer[]> sortedArrayList){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        sortedArrayList.forEach(arr -> {
            for(int j = 0; j < arr.length; j++){
                pq.add(arr[j]);
            }
        });
        printSortedList(pq);
    }
    private static  void printSortedList(PriorityQueue<Integer> pq){
        ArrayList<Integer> arr = new ArrayList<>();

        while (!pq.isEmpty()){
        arr.add(pq.remove());
        }
        System.out.println("kth sorted list is ");
        arr.forEach(i -> {
            System.out.print(i + ",");
        });
    }
    public static void main(String[] args) {
        ArrayList<Integer[]> sotedArr = new ArrayList<>();
        Integer arr1 [] = {1,7,9,11};
        Integer arr2[] = {2,18,23,27,31};
        Integer arr3[] = {84,101,103};
        sotedArr.add(arr1);
        sotedArr.add(arr2);
        sotedArr.add(arr3);
        sortKSortedArr(sotedArr);

    }
}
