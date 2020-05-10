package arrays;

public class CountZeroInSortedArr {

    private static  void printZero(int arr[]){
        int n = arr.length;
        int mid = n/2;
        int start = mid, end = mid;
        if(arr[mid] == 0){
            while(start >=0 && arr[start--] == 0){
                if(start == 0){
                    break;
                }
                start--;
            }
            while (end < n && arr[end] == 0){
                if(end == n-1){
                    break;
                }
                end++;
            }
        }
        else if(arr[mid] == 1){
             while(arr[mid] != 0 && mid >= 0){
                 mid--;
             }
             end = mid;
             start = 0;
        }
        System.out.println("{ " + start +", "+end + " }");
    }
    public static void main(String[] args) {
        int arr[] =  {0,0,0,1,1};
        printZero(arr);

    }
}
