package binarySearch;
/*array is circular
*
* */
public class SearchNextLetter {

    private static char findNextLetter(char arr[], char c){
        int n = arr.length;
        if(arr[0] > c || arr[n-1] < c ){
            return arr[0];
        }
        int start = 0, end = n;
        while (start <= end){
            int mid = start +(end - start)/2;
            if(c < arr[mid]){
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }
        return arr[start%n];

    }

    public static void main(String[] args) {
        char arr [] = {'a','c','f','h'};
        System.out.println(findNextLetter(arr,'h'));
    }
}
