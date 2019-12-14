package arrays;

public class CountZeroInSortedArr {

    private static  void printZero(int arr[]){
        int n = arr.length;
        int mid = n/2 +1;
        int start = 0;
        if(arr[mid] == 0){
            int i = mid;
            while(arr[i] == 0){
                i--;
            }
            start = i;
        }
        if(arr[mid] == 1){

        }
    }
    public static void main(String[] args) {
        int arr[] =  {1,1,1,1,1,1,0,0,0};

    }
}
