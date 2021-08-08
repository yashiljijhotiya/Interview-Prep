package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstLastOccurrence {

    private static List<Integer> countXOccurrence(int arr[], int x){
        int n = arr.length;
        if(arr == null && n == 0 || arr[n-1] < x){
            return new ArrayList<>();
        }
        int firstIndex = getFirstOccurrence(arr,x);
        System.out.println("firstIndex : " + firstIndex);
        int lastIndex = getLastOccurrence(arr,x);
        System.out.println("lastIndex : "+ lastIndex);
        return Arrays.asList(firstIndex, lastIndex);
    }


    private static int getFirstOccurrence(int arr[], int candidate){
        int startIndex = 0, endIndex = arr.length -1;
        int result = -1;
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if(arr[midIndex] == candidate){
                result = midIndex;
                endIndex = midIndex - 1;
            }
            else if(arr[midIndex] < candidate){
                startIndex = midIndex + 1;
            }
            else {
                endIndex = midIndex - 1;
            }
        }
        return result;
    }

    private static int getLastOccurrence(int arr[], int candidate){
        int startIndex = 0, endIndex = arr.length - 1;
        int result = -1;
        while(startIndex <= endIndex){
            int midIndex = startIndex + (endIndex - startIndex)/2;
            if(arr[midIndex] == candidate){
                result = midIndex;
                startIndex = midIndex + 1;
            }
            else if(arr[midIndex] < candidate){
                startIndex = midIndex + 1;
            }
            else {
                endIndex = midIndex - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,1,1,1,1,2,2,2,2,5,11,19,22};
        System.out.println(countXOccurrence(arr, 2));
    }
}
