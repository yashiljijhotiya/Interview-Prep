package recursion;

public class ReverseArr {

    private static void reverse(int [] arr, int n, int i){
        if(i >= n/2){
            return;
        }
        swap(arr, arr[i], arr[n-i-1]);
        reverse(arr, n, i+1);
    }

    private static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void print(int [] arr){
        for(int i : arr){
            System.out.print(i);
            System.out.print(", ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5};
        int n = arr.length;
        reverse(arr, n, 0);
        print(arr);
    }
}
