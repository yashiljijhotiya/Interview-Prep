package binarySearch;

import java.util.Arrays;

/**
 * Leetcode: 475
 * TC: sorting will be m*(log(m)) where m is the length of heater array || n * log(m)  if(n > m) where n is
 * the length of houses array
 *
 * We have to find for every house just smaller val of heater from left and right which is nothing but Ceil and floor
 * in an sorted array
 * */
public class Heater {

    private static class Pair{
        // here -1 represent there is no heater present for that particular house either on left or right or both
        int leftDist = -1;// represent floor
        int rightDist = -1; // represent ceil

        Pair(){}

        Pair(int leftDist, int rightDist){
            this.leftDist = leftDist;
            this.rightDist = rightDist;
        }
    }

    private static int findRadius(int [] houses, int [] heaters){
        if(heaters == null || heaters.length == 0 || houses == null || houses.length == 0){
            return 0;
        }
        int result = 0;
        // sort heaters dist to apply binary search and from distance pick the min for every house and take the max among them which will be the max radius and answer of the problem
        Arrays.sort(heaters);
        for(int location : houses){
            Pair pair = binarySearch(heaters, location);
            int leftDist = pair.leftDist == -1 ? Integer.MAX_VALUE : location - pair.leftDist;
            int rightDist = pair.rightDist == -1 ? Integer.MAX_VALUE : pair.rightDist - location;
            int minDist = Math.min(leftDist, rightDist);
            if(result < minDist){
                result = minDist;
            }
        }
        return result;
    }


    private static Pair binarySearch(int [] heater, int val){
        int left = 0;
        int right = heater.length-1;
        Pair pair = new Pair();
        while(left <= right){
            int mid = left + (right - left)/2;
            if(heater[mid] == val){
                pair.leftDist = heater[mid];
                pair.rightDist = heater[mid];
                break;
            }
            else if(val > heater[mid]){
                pair.leftDist = heater[mid];
                left = mid+1;
            }
            else {
                pair.rightDist = heater[mid];
                right = mid-1;
            }
        }
        return pair;
    }

    public static void main(String[] args) {
        int [] houses = {1,5};
        int [] heaters = {2};
        System.out.println("min radius required to heat all the houses are : " + findRadius(houses, heaters));

    }
}
