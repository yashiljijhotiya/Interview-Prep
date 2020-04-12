package arrays;

public class RemoveDuplicateFromSortedArr {

    private static int removeDuplicate(int arr[]){
        int n =  arr.length;

        if(arr == null){
            return -99999999;
        }

        if(n == 0 || n == 1){
            return n;
        }
        int j = 0;
        for (int i = 0; i < n-1; i++){
            if(arr[i] != arr[i+1]){
                arr[j++] = arr[i];
            }
        }
        arr[j++] = arr[n-1];
        return j;
    }
    public static void main(String[] args) {
        int arr [] = {1,2,2,2,2,2,3,3,4,4,4,4,5,5,5,6};
        int j = removeDuplicate(arr);
        for (int i = 0; i < j; i++){
            System.out.println(arr[i]);
        }
    }
}
