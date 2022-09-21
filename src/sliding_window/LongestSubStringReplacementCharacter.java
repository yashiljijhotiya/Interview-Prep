package sliding_window;

import java.util.HashMap;

public class LongestSubStringReplacementCharacter {

    private static int findMaxLen(String s, int k){
        int start = 0, end, maxLen = 0, maxRepeatCount = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
            maxRepeatCount = Math.max(freqMap.get(c), maxRepeatCount);
            if(end - start + 1 - maxRepeatCount > k){
                char ch = s.charAt(start);
                freqMap.put(ch, freqMap.get(ch) -1);
                start++;
            }
            maxLen = Math.max(maxLen, end - start +1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabcadb";
        System.out.println(findMaxLen(s, 2));
    }
}
