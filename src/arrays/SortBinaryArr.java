package arrays;

public class SortBinaryArr {

    private static  void printSortedBinaryArr(int arr[]){
        int j = -1;
        int n = arr.length;
        for(int i = 0; i < n;i++){
            if(arr[i] < 1){
                j++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + ", ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,0,0,0,1,0,1};
        printSortedBinaryArr(arr);
    }
}
