package dp.lcs;

public class LongestPalindromicSubsequence {

    private static int findLPS(String s){
        return lpsRec(s,0, s.length()-1);
    }

    private static int lpsRec(String s, int start, int end){
        if(start > end){
            return 0;
        }
        if(start == end){
            return 1;
        }
        if(s.charAt(start) == s.charAt(end)){
            return 2 + lpsRec(s, start+1, end-1);
        }
        int c1 = lpsRec(s, start+1, end);
        int c2 = lpsRec(s,start, end-1);

        return Math.max(c1,c2);
    }


    private static int lpsMemo(String s, int start, int end, Integer dp[][]){
        if(start > end){
            return 0;
        }
        if(start == end){
            return 1;
        }
        if(dp[start][end] == null){

            if(s.charAt(start) == s.charAt(end)){
                dp[start][end] = 2 + lpsMemo(s,start+1, end-1,dp);
            }
            else {
                int c1 = lpsMemo(s,start+1, end, dp);
                int c2 = lpsMemo(s,start,end-1, dp);
                dp[start][end] = Math.max(c1,c2);
            }
        }
       return dp[start][end];
    }

    private static int lpsBottomUp(String s, int start, int end, int dp[][]){
        for(int i = 0; i < s.length();i++){
            dp[i][i] = 1;
        }
        return dp[0][s.length()-1];
    }

  public static void main(String[] args) {

  }
}
