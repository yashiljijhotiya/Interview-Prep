package binarySearch;

public class NoOfTimesArrayRotated {
/**
 * - the index of min element will tell you the no. of times array is rotated
 * - the min element is always present in unsorted half
 * */
    private static int countNoOfRotations(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        // if array is not rotated
        if( arr[0] < arr[n-1]){
            return 0;
        }
        int start = 0, end  = n-1;
        while (start <= end ){
            int mid = start + (end - start)/2;
            /**
             * checking if  mid element is the min val
                Taking modulo coz if first element is mid or last element is mid in that case prev and next will
                go out of bound
             **/
            int prev = (mid-1+n)%n, next = (mid+1)%n;
            if(arr[mid] <= prev && arr[mid] <= next){
                return mid;
            }
            if(arr[start] < arr[mid]){
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {10,15,19,21,1,3,8,9};
        System.out.println(countNoOfRotations(arr));
    }
}
