package problem_solving;

public class NextPermutation {

    private static void nextPermutation(int arr[]){
        if(arr.length == 0 || arr == null){
            return;
        }
        else if(arr.length == 1){
            return;
        }
        else if(arr.length == 2){
            swap(arr,0,1);
        }
        int end = arr.length-1;
        while(end >= 0  && arr[end-1] >= arr[end]){
            end--;
        }
        reverse(arr,end+1, arr.length-1);
        if(end < 0){
            return;
        }

    }

    private static int [] swap(int arr[],int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return arr;
    }

    private static void reverse(int arr[], int start, int end){
        while (start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    public static void main(String[] args) {

    }
}
