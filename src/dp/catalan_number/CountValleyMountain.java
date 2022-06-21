package dp.catalan_number;

public class CountValleyMountain {

    private static int countValleyMountains(int strokes){
        int dp[] = new int[strokes+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= strokes; i++){
            int inside = i - 1;
            int outside = 0;
            while(inside >= 0){
                dp[i] += dp[outside] * dp[inside];
                inside--;
                outside++;
            }
        }
        return dp[strokes];
    }

    public static void main(String[] args) {
        System.out.println("no. valley mountains forms are : " + countValleyMountains(4));
    }
}
