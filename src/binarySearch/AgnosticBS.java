package binarySearch;
/* Agnostic array is the array which is sorted but the sorted order is not known
* */
public class AgnosticBS {

    private static int findElement(int arr[], int x){
        boolean isAscending;
        int start = 0, end = arr.length-1;
        isAscending = arr[start] < arr[end] ? true : false;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                return mid;
            }
            if(isAscending){
                if(arr[mid] < x){
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }

            }
            else {
                if(arr[mid] < x){
                    end = mid-1;
                }
                else {
                    start = mid+1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
