package binarySearch;

public class NoOfTimesArrayRotated {

    private static int countNoOfRotations(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int start = 0, end  = arr.length-1;
        while (start < end ){
            int mid = start + (end -start)/2;
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid+1;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
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
        int arr[] = {10,15,19,1,3,8};
        System.out.println(countNoOfRotations(arr));
    }
}
