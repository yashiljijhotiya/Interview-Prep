package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//TC : O(n^2)
public class WordBreakProblem {

    private static boolean wordBreak(String word, List<String> dictionary){
        if(word.isEmpty() || word.length() == 0 || dictionary == null || dictionary.size() == 0){
            return false;
        }
        HashSet<String> set = new HashSet<>(dictionary);
        boolean [] dp = new boolean[word.length() +1];
        // empty string always present in dictionary
        dp[0] = true;
        for(int i = 1; i < word.length(); i++){
            for (int j = 0; j < i; j++){
                if(dp[j] && set.contains(word.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }
    public static void main(String[] args) {
        String word = "leetcode";
        List<String> dictionary = new ArrayList<>();
        dictionary.add("leet");
        dictionary.add("code");
        System.out.println(wordBreak(word,dictionary));
    }
}
