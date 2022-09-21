package sliding_window;

import java.util.Arrays;

public class SWPractice {

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int start = 0, end;
        for (end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            if (end - start + 1 == k) {
                result[start] = windowSum / k;
                windowSum -= arr[start];
                start++;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
