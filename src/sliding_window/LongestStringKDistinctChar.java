package sliding_window;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringKDistinctChar {

    private static int longestSubStrKDisChar(String str, int k){
        int windowSize = Integer.MIN_VALUE, start = 0, end = 0;
        Map<Character,Integer> frequencyMap = new HashMap<>();

        for(end = 0; end < str.length(); end++){
            frequencyMap.put(str.charAt(end), frequencyMap.getOrDefault(str.charAt(end),0) +1);

            while(frequencyMap.size() > k){
                frequencyMap.put(str.charAt(start), frequencyMap.get(str.charAt(start))-1);
                if(frequencyMap.get(str.charAt(start)) == 0){
                    frequencyMap.remove(str.charAt(start));
                }
                start++;
            }
           windowSize = Math.max(windowSize,end-start+1);
        }

        return windowSize;
    }
    public static void main(String[] args) {
        System.out.println(longestSubStrKDisChar("arraci", 2));
    }
}
