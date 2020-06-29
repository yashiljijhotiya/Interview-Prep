package binarySearch;

public class SearchInRotatedArr {

    private static int searchElement(int arr[], int val){
        int start = 0, end = arr.length-1;
        while (start <= end){
            int mid  = start + (end - start)/2;
            if(arr[mid] == val){
                return mid;
            }
            if(arr[mid] >= arr[start]){
                if(val >= arr[start] && val < arr[mid]){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }
            }
            else {
                if(val > arr[mid] && val <= arr[end]){
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {10,15,1,3,8};
        System.out.println(searchElement(arr,15));

    }
}
