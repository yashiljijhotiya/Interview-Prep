package sliding_window;
// Longest window that contains all distinct characters;

import java.util.HashMap;
import java.util.Map;

public class LongestWindowDistinctChar {

    private static final int MAX_CHAR = 26;

    private static int longestWindow(String str){
        int len = str.length();
        if(str == null || len == 0){
            System.out.println("String is empty");
            return 0;
        }
        Map<Character,Integer> freqMap = new HashMap<>();
        int windowStart = 0, maxLength = 0, windowEnd;
        for(windowEnd = 0; windowEnd < len; windowEnd++ ){
            char val = str.charAt(windowEnd);
            if(freqMap.containsKey(val)){
                windowStart = Math.max(windowStart, freqMap.get(val)+1);
            }
            freqMap.put(val,windowEnd);
            maxLength = Math.max(maxLength,windowEnd -windowStart +1);
        }

        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println("longest substring contains all distinct character is :" + longestWindow("aabccbb"));
    }
}
