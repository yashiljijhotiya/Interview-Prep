package binarySearch;
/** Leetcode: 875 (med)
 *
 * */
public class KokoBananaProblem {

    private static int minEatingSpeed(int [] piles, int h){
        int left = 1; // min speed of koko eating banana
        int right = findMax(piles);// max speed of koko to eat banana
        int result  = right;
        while (left <= right){
            int k = left + (right-left)/2;
            int hours = 0;
            for (int p : piles){
               hours += p/k;
            }
            if(hours < h){
                result = Math.min(result, k);
                right = k-1;
            }
            else {
                left = k+1;
            }
        }
        return  result;
    }

    private static int findMax(int [] piles){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int [] piles = {3,6,7,11 };
        int h = 8;
        System.out.println(minEatingSpeed(piles,h));

    }
}
