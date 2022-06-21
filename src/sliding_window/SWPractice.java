package sliding_window;

public class SWPractice {

    public static void main(String[] args) {
        int []arr = {1,3,2,6,-1,4,1,8,2};
        int k = 5;
        double [] result = new double[arr.length - k + 1];
        int windowSum = 0;
        int start = 0, end;
        for(end = 0; end < arr.length; end++){
            windowSum += arr[end];
            if(end <= k -1){
                result[start] = windowSum/k;
                windowSum -= arr[start];
                start++;
            }
        }

    }
}
