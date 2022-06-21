package binarySearch;

public class ElementInRotatedArray {

    private static int findElementInRotatedArr(int arr[], int key){
        int minIndex = findMinElementIndex(arr);
        int leftIndex = findElement(arr,key, 0, minIndex -1);
        int rightIndex = findElement(arr, key, minIndex +1, arr.length-1);
        return leftIndex != -1 ? leftIndex : rightIndex;
    }

    private static int findElement(int arr[], int key, int start, int end){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                start = mid+1;
            }
            else{
                end  = mid-1;
            }
        }
        return -1;
    }

    private static int findMinElementIndex(int arr[]){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int n = arr.length;
        if(n == 1 || arr[0] < arr[n-1]){
            return 0;
        }
        int start = 0, end = n-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[start] > arr[mid]){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        System.out.println(findElementInRotatedArr(arr, 1));

    }
}
