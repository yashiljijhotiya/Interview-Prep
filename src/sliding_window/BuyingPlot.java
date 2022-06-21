package sliding_window;

// Find subarray of min length whose sum is k
public class BuyingPlot {

    private static int minLengthSegment(int plots[], int plotLen){
        int result = 0;
        int min_length = Integer.MAX_VALUE;
        int start = 0;
        for(int end = 0; end < plots.length; end++){
            if(result == plotLen){
                min_length = Integer.min(min_length, end-start+1);
            }
            if(result < plotLen){
                result += plots[end];
            }
            if(result > plotLen){
                result = result- plots[start];
                start++;
            }
        }

        return min_length;

    }

    private static int findMinSubArray(int arr[], int s){
        if(arr == null || arr.length == 0 ){
            return 0;
        }
        int sum = 0, min = Integer.MAX_VALUE, start = 0, end;
        for(end = 0;  end < arr.length; end++){
            sum += arr[end];

            while(sum >= s){
                min = Math.min(min, end - start);
                sum -= arr[start];
                start++;
            }
        }

        return min;
    }
    public static void main(String[] args) {

        int [] plots = {1,3,2,1,4,1,3,2,1,1,2};
        System.out.println("min no.  of plots required is :" + findMinSubArray(plots, 8));

    }
}
