package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*Leetcode: 2063
*Each char contribute (len - index) alone always.
	for eg : abce , here a alone can contribute (4-0) with substring formed with a
	*
	* Idea is : traverse from right to left,  find the contribution of (each character + substring formed with that character)
	formula used : if vowel (len - index) + prev
							otherwise use prev calculated value
* */
public class VowelsCount {

    private static long countVowels(String s){
        int len = s.length();
        if(s == null || len <= 0){
            return 0;
        }
        long dp[] = new long[s.length()];
        long count, result = 0, prev = 0;
        for(int i = len -1; i >= 0; i--){
            char c = s.charAt(i);
            count = 0;
            if(isVowel(c)){
                count = (len -1) + prev;
                dp[i] = count;
                prev = dp[i];
            }
            else {
                count = prev;
            }
            result += count;
        }
        return result;
    }

    private static boolean isVowel(char ch){
     Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
     if(vowelSet.contains(ch)){
         return true;
     }
     else {
         return false;
     }
    }
    public static void main(String[] args) {
        String s = "aba";
        System.out.println("no. of vowels present in all the sub string are : "+countVowels(s));

    }
}
