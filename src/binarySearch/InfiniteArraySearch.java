package binarySearch;
/* unbounded array of infinite size
*Let i be the position of the element to be searched, then the number of iterations for finding upper index
* 'r' is equal to O(log i) in the worst case. Similarly, The total number of elements between l and r = O(i)
*  (Think)
Time complexity = finding upper index 'r' of the interval + Binary Search from l to r = O(log i) + O(log i ) = O(log i)
Space Complexity: O(1) if we use iterative binary search.
*
* */
public class InfiniteArraySearch {

 private static int findIndex(int arr[], int k){

     int l, r;

     int windowIndex[] = findWindow(arr,0,1,k);
     l = windowIndex[0];
     r = windowIndex[1];

     while(l <= r){
         int mid = l + r-l/2;
         if(arr[mid] == k){
             return mid;
         }
         if(arr[mid] < k){
             l = mid+1;
         }
         else{
             r = mid-1;
         }
     }

     return -1;
 }

    // to find the window in which value k lies
    private static int[] findWindow(int arr[], int start, int end, int val){
     int res[] = new int[2];
     while (arr[end] < val){
         int newStart = end + 1;
         end += (end - start + 1) * 2;
         start = newStart;
     }
     res[0] = start;
     res[1] = end;
     return res;
    }

    public static void main(String[] args) {

    }
}
