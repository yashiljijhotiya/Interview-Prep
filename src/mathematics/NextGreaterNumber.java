package mathematics;
import java.util.Arrays;

public class NextGreaterNumber {

    private static void findNextGreaterNum(int arr[]){
        int i;
        for(i = arr.length-1; i > 0; i--){
           if(arr[i-1] < arr[i]){
               break;
           }
       }
        if(i == 0){
            System.out.println("Not possible");
        }
        else {
            Arrays.sort(arr, i, arr.length-1);
            int temp = arr[i-1];
            arr[i-1] = arr[i];
            arr[i] = temp;
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[j]);
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {5,3,4,9,7,6}; //4,6,7,9
        findNextGreaterNum(arr);
    }
}
