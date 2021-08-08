package arrays;

public class MoveZeroToLeft {

    private static void moveZeroToLeft(int arr[]){
        if(arr.length <= 1){
            return;
        }
        int readIndex =  arr.length-1, writeIndex = arr.length-1;

        while (readIndex >= 0){
            if(arr[readIndex] != 0){
                arr[writeIndex] = arr[readIndex];
                writeIndex--;
            }
            readIndex--;
        }

        while (writeIndex >= 0){
            arr[writeIndex] = 0;
            writeIndex--;
        }
        System.out.print("{ ");
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.print("}");
    }
    public static void main(String[] args) {
        int arr[] = {12,0,8,11,2,0,5,7,0};
        moveZeroToLeft(arr);

    }
}
