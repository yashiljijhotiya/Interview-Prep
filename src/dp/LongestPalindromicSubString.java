package dp;

public class LongestPalindromicSubString {

    private static String lps(String str){
        int maxLen = 1;
        int len = str.length();
        int startIndex = 0;
        if(str == null || len == 0){
            return "";
        }
        if(len == 1){
            return str;
        }

        boolean dp[][] = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        for(int i = 0; i < len-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = true;
                startIndex = i;
                maxLen = 2;
            }
        }

        for(int cur_len = 3; cur_len < len; cur_len++){
            for (int i = 0;  i < len-cur_len+1; i++){
                int j = i+cur_len-1;
                if(str.charAt(i) == str.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    if(cur_len > maxLen){
                        startIndex = i;
                        maxLen = cur_len;
                    }
                }
            }
        }

        return str.substring(startIndex,maxLen);
    }

    public static void main(String[] args) {
        String str = "aaaaabaaa";
        System.out.println(lps(str));
    }
}
