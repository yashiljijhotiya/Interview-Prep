package amazon;

public class EditDistance {

    private  static int editDistance(String str1, String str2){
        int dp[][] = new int[str1.length()+1][str2.length()+1];

        for(int i=0; i < dp[0].length; i++){
            dp[0][i] = i;
        }

        for(int i=0; i < dp.length; i++){
            dp[i][0] = i;
        }

        for(int i=1;i <=str1.length(); i++){
            for(int j=1; j <= str2.length(); j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);
                }
            }
        }

        return dp[str1.length()][str2.length()];

    }

    public static void main(String[] args) {
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println(editDistance(s1,s2));
    }
}
