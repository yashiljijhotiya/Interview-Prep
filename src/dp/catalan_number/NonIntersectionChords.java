package dp.catalan_number;
/**
 *  Given even no. of points in circle, find no. of non intersection chords possible
 *  Here points will be in pair
 * */
public class NonIntersectionChords {

    private static int countNoOfChord(int points){

        int [] dp = new int[points+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= points; i++){
            int l = 0;
            int r = i -1;
            while(l < i){
                dp[i] += dp[l]*dp[r];
                l++;
                r--;
            }
        }
        return dp[points];
    }

    public static void main(String[] args) {
        System.out.println("no. non intersection chord formed are :"+ countNoOfChord(3));
    }
}
