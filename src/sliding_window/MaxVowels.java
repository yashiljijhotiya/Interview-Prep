package sliding_window;
import java.util.Set;

public class MaxVowels {
    private static final Set<Character> VOWELS =  Set.of('a','e','i','o','u');

    private static int maxVowels(String str, int k){
        if(str.isEmpty() || str == null){
            return 0;
        }
        int start = 0, end, max = Integer.MIN_VALUE, vowelCount = 0;
        for(end = 0; end < str.length(); end++){
            if(VOWELS.contains(str.charAt(end))){
               vowelCount++;
            }
            while(end - start >= k){
                if(VOWELS.contains(str.charAt(start))){
                    vowelCount--;
                }
                start++;
            }
            max = Math.max(max, vowelCount);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        System.out.println(maxVowels(s,3));
        System.out.println(maxVowels("aeiou",2));
        System.out.println(maxVowels("leetcode",3));
        System.out.println(maxVowels("rhythms",4));
    }
}
