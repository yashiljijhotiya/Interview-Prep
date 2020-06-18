package binarySearch;
//TC : log(n)
public class BinarySearch {

    private static int findElement(int arr[], int num){
        if(arr == null || arr.length == 0 || num > arr[arr.length-1]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid  = start + end - start/2; //to avoid integer overflow
            if(arr[mid] == num){
                return mid;
            }
            else if(arr[mid] < num){
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int arr[] = {2,4,7,11,19,21,66,89,144,188};
        System.out.println(findElement(arr,11));
        System.out.println(findElement(arr,111));
        System.out.println(findElement(arr,188));
        System.out.println(findElement(arr,2));

    }
}
