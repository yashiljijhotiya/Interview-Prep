package binarySearch;
/* Ceiling : ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
*  Floor : The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’.
* */
public class FloorCeiling {

    private static int findCeiling(int arr[], int x){
        int start = 0,  end = arr.length-1;
        if(x > arr[end]){
            return -1;
        }
        while (start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < x){
                start = mid+1;
            }
            else if(arr[mid] > x){
                end = mid-1;
            }
            else {
                return mid;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array, so the next big number will be arr[start]
        return start;
    }

    private static int findFloor(int arr[], int x){
        int start = 0, end = arr.length-1;
        int result = -1;
       while(start <= end){
           int mid  = start + (end-start)/2;
           if(arr[mid] == x){
               result = arr[mid];
               break;
           }
           else if(arr[mid] > x){
               end = mid-1;
           }
           else {
               result = arr[mid];
               start = mid+1;
           }
       }
       return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,8,10,15};
        System.out.println(findCeiling(arr,12));
        System.out.println(findFloor(arr,12));
    }

}
