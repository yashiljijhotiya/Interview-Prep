package arrays;

public class MaxDifferenceInArray {

    private static int maxDiff(int arr[]){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int result;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(max < arr[i]){
                max = arr[i];
            }
        }
        result = max - min;
        return result;
    }
    public static void main(String[] args) {
        int arr [] = {80, 2, 6, 3, 100};
        System.out.println("max difference b/w 2 elements in array :" + maxDiff(arr));
    }
}
