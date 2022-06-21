package binarySearch;
/**
 * Leetcode: 1011
 * */
public class    CapacityToShip {

    private static int shipWithInDays(int [] weights, int days){
        int left = 0, right = 0;
        // through this loop we will be finding the range
        for(int weight : weights){
            right += weight;
            if(left < weight){
                left = weight;
            }
        }
        while (left <= right){
            int capacity = left + (right - left)/2;
            int requireDays = findRequireDays(weights, capacity);
            if(requireDays > days){
                left = capacity+1;
            }
            else {
                right = capacity-1;
            }
        }
        return left;
    }

    private static int findRequireDays(int [] weights, int maxCap){
        int requireDays = 1;
        int capacity = 0;
        for(int weight : weights){
            capacity += weight;
            if(capacity > maxCap){
                requireDays++;
                capacity = weight;
            }
        }
        return requireDays;
    }

    public static void main(String[] args) {
        int [] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        System.out.println(shipWithInDays(weights,days));
    }
}
