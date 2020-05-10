package arrays;

public class ArrayUtils {

    protected static void print(int arr[]){
        if(arr == null || arr.length == 0){
            return;
        }
        System.out.print("[ ");
        for(int i : arr){
            System.out.print(i + ", ");
        }
        System.out.print(" ]");
        System.out.println();
    }

    protected static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    protected static void reverse(int arr[], int start, int end){
        while (start < end){
            swap(arr,arr[start],arr[end]);
            start++;
            end--;
        }
    }
}
