package cyclic_sort;

import java.util.Arrays;
/**
 * The time complexity of the above algorithm is O(n)
 * O(n)
 * . Although we are not incrementing the index i when swapping the numbers, this will result in more than n iterations of the loop, but in the worst-case scenario, the while loop will swap a total of n-1 numbers, and once a number is at its correct index, we will move on to the next number by incrementing i. So overall, our algorithm will take O(n) + O(n-1)
 * O(n)+O(n−1)
 *  which is asymptotically equivalent to O(n)
 * O(n)
 * .
 *
 * */
public class CyclicSort {
    private static void sort(int arr[]){
        if(arr == null || arr.length == 0){
            return;
        }
        int i = 0, n = arr.length;
        while(i < n){
            int j = arr[i] - 1;
            if(arr[i] != arr[j]){
                swap(arr, i, j);
            }else{
                i++;
            }
        }
        Arrays.stream(arr).forEach(e -> System.out.println(e));
    }
    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int arr[] = {4,7,1,5,6,2,3};
        sort(arr);
    }
}
