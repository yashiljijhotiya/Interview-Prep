package leetcode;

/*Leetcode : 1326

* */
public class MinTapGarden {

    private static int findMinTap(int n, int[] ranges){
        int min = 0, max = 0, openTaps = 0;
        while(max < n){
            for(int i = 0; i < ranges.length; i++){
                if(i-ranges[i] <= min && i+ranges[i] > max){
                    max = i + ranges[i];
                }
            }
            // if all ranges is 0 or not able to give water completely
            if(min == max){
                return -1;
            }
            openTaps++;
            min = max;
        }
        return openTaps;
    }

    public static void main(String[] args) {
        int [] ranges = {3,4,1,1,0,0};
        System.out.println("min taps required to water garden are : " + findMinTap(ranges.length-1, ranges));
    }
}
