package amazon;
/*TC : log(n)
* */
public class CountXInSortedArray {

    private static int countXOccurrence(int arr[], int x){
        int n = arr.length;
        if(arr == null && n == 0 || arr[n-1] < x){
            return -1;
        }

        int i = findFirstOccurrence(arr, 0, n-1, x,n);
        if(i == -1){
            return i;
        }
        int j = findLastOccurrence(arr, i, n-1,x, n);
        return j - i + 1;
    }

    private static int findFirstOccurrence(int arr[], int low, int high, int x, int n){
        if(high >= low){
            int mid  = (low + high)/2;
            if((mid == 0 || x > arr[mid-1]) && arr[mid] == x){
                return mid;
            }
            else if(x > arr[mid]){
                return findFirstOccurrence(arr, mid+1, high, x, n);
            }
            else {
                return findFirstOccurrence(arr, 0, mid-1, x, n);
            }
        }
      return -1;
    }

    private static int findLastOccurrence(int arr[], int low, int high, int x, int n){

        if(high >= low){
            int mid  = (low + high)/2;
            if((mid == n-1 || x < arr[mid+1]) && arr[mid] == x){
                return mid;
            }
            else if(x > arr[mid]){
                return findLastOccurrence(arr, mid+1, high, x, n);
            }
            else {
                return findLastOccurrence(arr, 0, mid-1, x, n);
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1,1,1,1,2,2,2,2,5,11,19,22};
        System.out.println(countXOccurrence(arr, 2));
    }
}
