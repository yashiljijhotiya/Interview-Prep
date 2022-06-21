package binarySearch;

import java.util.Arrays;

/**
 * Leetcode 2064 (Med)
 * Similar Koko, pageAlocation,  Gas Station
 * */
public class MaxProductDistribution {

    private static int findMaxProductDistributed(int products[], int shops){
        // find range ie min will represented by left = 1(the min item we can assign to any shop) and right will be represented by max val present in the item
        int left = 1;
        int right = Arrays.stream(products).max().getAsInt();
        int result = 0;

        while (left <= right){
            int mid = left + (right - left)/2;
            if(isValid(products, mid)){
                result = mid;
                right = mid -1;
            }
            else {
                left = mid+1;
            }

        }
        return result;
    }

    private static boolean isValid(int [] products, int max){
        int count = 0;
        for(int prod: products){
            count += prod%max == 0 ? prod/max : prod/max +1;
        }
        return count <= 0;
    }

    public static void main(String[] args) {
        int [] products = {15,10,10};
        int shops = 7;
        System.out.println(findMaxProductDistributed(products,shops));
    }


}
