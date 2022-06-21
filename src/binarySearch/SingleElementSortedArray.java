package binarySearch;
/**
 * In order to check for the left half
 *  1st instance  : even index
 *  2nd instance : odd index, we need to check on the left if 1st instance of that number is there or not
 * */
public class SingleElementSortedArray {

    private static int findSingleNum(int arr[]){
        int n = arr.length;
        int low  = 0;
        int high = n -2;
        while (low <= high){
            int mid = (low + high) >> 1;
            if(arr[mid] == arr[mid^1]){
                low = mid+1;
            }
            else {
                high = mid - 1;
            }
        }
        return arr[low];
    }
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,4,5};
        System.out.println(findSingleNum(arr));
    }
}
