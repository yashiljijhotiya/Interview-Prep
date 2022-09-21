package sliding_window;

import java.util.HashMap;
/**
 * Leetcode: 76
 * TC: O(N)
 * SC: O(N)
 */

public class MinWindowSubstring {

    private static String findMinWindowLength(String str, String pattern) {
        if (pattern.length() > str.length())
            return "";

        HashMap<Character, Integer> patternMap = new HashMap<>();
        for (char ch : pattern.toCharArray())
            patternMap.put(ch, patternMap.getOrDefault(ch, 0) + 1);

        int matchCount = pattern.length();
        int count = 0;

        String ans = "";

        int start = 0;
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char ch = str.charAt(end);
            strMap.put(ch, strMap.getOrDefault(ch, 0) + 1);
            if (patternMap.containsKey(ch) && strMap.get(ch) <= patternMap.get(ch))
                count++;

            while (matchCount == count) {
                if (ans.equals("") || ans.length() > end - start + 1)
                    ans = str.substring(start, end + 1);

                char c = str.charAt(start);
                strMap.put(c, strMap.getOrDefault(c, 0) - 1);
                if (patternMap.containsKey(c) && strMap.get(c) < patternMap.get(c))
                    count--;
                start++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pattern = "ABC";
        System.out.println(findMinWindowLength(str, pattern));
    }
}
