package dp;

import java.util.HashSet;

public class DistinctPalindromicSubstring {

    private static void printDistinctPalindromicSubstring(String s){
        int len = s.length();
        if(s == null || s.length() == 0){
            return;
        }
        boolean dp[][] = new boolean[len][len];
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < len; i++){
            for(int j = i; j < len; j++){
                int a = j-i;
                int b = j;
                if(i == 0){
                    dp[a][b] = true;
                    set.add(s.substring(a,b+1));
                    continue;
                }

                if(i == 1){
                    if(s.charAt(a) == s.charAt(b)){
                        dp[a][b] = true;
                        set.add(s.substring(a,b+1));
                    }
                    continue;
                }
                if(s.charAt(a) == s.charAt(b) && dp[a+1][b-1]){
                    dp[a][b] = true;
                    set.add(s.substring(a,b+1));
                }
            }
        }
        System.out.println(set.size());
        System.out.println(set);
    }
    public static void main(String[] args) {
        String s = "abaaa";
        printDistinctPalindromicSubstring(s);
    }
}
