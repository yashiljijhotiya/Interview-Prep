package dp;

import java.util.HashSet;
import java.util.List;
/* Rec TC : O(n^n)
*
* */
public class WordBreak {

    private static boolean wordBreak(String s, List<String> dictionary){
        return wordBreakRec(s,new HashSet<>(dictionary),0);

    }

    private static boolean wordBreakRec(String s, HashSet<String> dictionary, int start){
        if(start == s.length()){
            return true;
        }
        for(int end = start+1; end <= s.length(); end++){
            if(dictionary.contains(s.substring(start,end)) &&
            wordBreakRec(s,dictionary,end)){
                return true;
            }
        }
        return false;
    }

    //Top down
    private static boolean wordBreakMem(String s, HashSet<String> dictionary, int start, Boolean[] dp){
        if(start == s.length()){
            return true;
        }
        if(dp[start] != null){
            return dp[start];
        }
        for(int end = start+1; end <= s.length(); end++){
            if(dictionary.contains(s.substring(start,end))&& wordBreakMem(s,dictionary,end,dp)){
                dp[start] = true;
            }
        }
        return dp[start] = false;
    }

  public static void main(String[] args) {

  }
}
