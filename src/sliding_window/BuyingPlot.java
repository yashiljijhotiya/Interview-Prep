package sliding_window;

// Find subarray of min length whose sum is k
public class BuyingPlot {

    private static int minLengthSegment(int plots[], int plotLen){
        int result = 0;
        int min_length = Integer.MAX_VALUE;
        int i = 0;
        for(int j = 0; j < plots.length; j++){
            if(result == plotLen){
                min_length = Integer.min(min_length, j-i+1);
            }
            if(result < plotLen){
                result += plots[j];
            }
            if(result > plotLen){
                result = result- plots[i];
                i++;
            }
        }

        return min_length;

    }
    public static void main(String[] args) {

        int [] plots = {1,3,2,1,4,1,3,2,1,1,2};
        System.out.println("min no.  of plots required is :" + minLengthSegment(plots, 8));

    }
}
