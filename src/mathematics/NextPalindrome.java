package mathematics;

public class NextPalindrome {

    private static void nextPalindrome(int arr[]){
        if(arr == null | arr.length == 0){
            return;
        }
        int len = arr.length;
        int mid = len/2;
        int left = mid-1, right;
        right = (len%2 == 0)? mid : mid+1;
        //even length
        if(len%2 == 0){
            /* midLeft is greater than midRight
             -> override midLeft with midRight digit.
             -> take mirror of left half digit and override with right half digit
            * */
            if(arr[left]>arr[right]){
               arr[right] = arr[left];
            }
            /*midLeft is smaller than midRight
            -> Add 1 to midLeft
            -> take mirror of left half digit and override with right half digit
            * */
            else if(arr[left] < arr[right]){
                if(arr[left] < 9){
                    arr[left] = arr[left]+1;
                }
                else {
                  arr[left] = 0;
                  arr[left--] = arr[left]+1;
                }
                arr[right] = arr[left];
            }
        }
        //all nine
        else if(checkForAll9(arr)){
            System.out.print(1);
            for(int i = 0; i < len-1; i++){
                System.out.print(0);
            }
            System.out.print(1);
        }
        //odd
        else {
            while(arr[left] == arr[right]){
                left--;
                right++;
            }
            if(arr[left] > arr[right]){
                arr[right] = arr[left];
            }
            else if(arr[left] < arr[right]){
                if(arr[mid] < 9){
                    arr[mid] = arr[mid]+1;
                }
                else{
                    arr[mid] = 0;
                    arr[left] = arr[left]+1;
                }
                arr[right] = arr[left];
            }

        }
        right++;
        left--;
        while(left >= 0){
            arr[right++] = arr[left--];
        }

        for(int a : arr){
            System.out.print(a);
        }
    }

    private static boolean checkForAll9(int arr[]){
        boolean allNine = true;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] != 9){
                allNine = false;
                break;
            }
        }
        return allNine;
    }

    public static void main(String[] args) {
        int arr[] = {9,9,9};
        nextPalindrome(arr);
    }
}
