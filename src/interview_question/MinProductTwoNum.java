package interview_question;

import java.util.Arrays;

public class MinProductTwoNum {

    private static int minProduct(int arr[]){
        int len = arr.length;
        if(len == 0 || arr == null){
            return 0;
        }

        if(arr.length == 1){
            return arr[0];
        }

        if(arr.length == 2){
            return arr[0]*arr[1];
        }

        Arrays.sort(arr);
        if(arr[len-1] < 0){
            return arr[len-1] * arr[len-2];
        }

        else if(arr[0] >= 0){
            return arr[0]*arr[1];
        }

        int i = 0;
        while (arr[i] < 0){
            i++;
        }
        return arr[i] == 0 ? arr[0]*arr[i+1] :  arr[0]*arr[i];
    }

//for no duplicate
    public static void main(String[] args) {
        //int arr[] = {-99,-2,1,77,54,3,11,-22,-1, 12};
       // int arr[] = {-99,-2,-1,-22,-1};
        int arr[] = {-7,0,1,77,54,3,11, 12};
        System.out.println(minProduct(arr));
    }
}
