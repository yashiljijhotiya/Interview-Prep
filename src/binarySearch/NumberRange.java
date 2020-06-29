package binarySearch;

import java.util.Arrays;

public class NumberRange {

    private static int [] findRange(int arr[], int num){
        int [] result = {-1,-1};
        result[0] = findIndex(arr,num,false);
        if(result[0] != -1){
            result[1] = findIndex(arr,num,true);
        }
        return result;
    }

    private static int findIndex(int arr[], int num, boolean maxIndex){
        int start = 0, end = arr.length-1, keyIndex = -1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < num){
                start = mid+1;
            }
            else if(arr[mid] > num){
                end = mid-1;
            }
            else {
                keyIndex = mid;
                if(maxIndex){
                    start = mid+1;
                }
                else {
                    end = mid-1;
                }
            }
        }
        return keyIndex;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,7,10,10,11,19};
        System.out.println(Arrays.toString(findRange(arr,10)));
    }
}
