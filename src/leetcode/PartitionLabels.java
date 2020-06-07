package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* */
public class PartitionLabels {

    private static List<Integer> partitionLabels(String S){
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return result;
        }

        // build map to store each characters last position
        Map<Character, Integer> lastPositions = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            lastPositions.put(S.charAt(i), i);
        }

        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < S.length(); windowEnd++) {

            // store the most right position of the current char. We will expand our window till there.
            char rightChar = S.charAt(windowEnd);
            int mostRightIndex = lastPositions.get(rightChar);

            // expand the window now...
            while (windowEnd < mostRightIndex) {
                // if I notice while processing, that another character occurred
                // who's last position is further to the right, adjust my windowSize and expand it further (update mostRightIndex)
                rightChar = S.charAt(windowEnd);
                mostRightIndex = Math.max(mostRightIndex, lastPositions.get(rightChar));
                windowEnd++;
            }
            // when I made it out this while loop, I will have a valid window. So store the size in result.
            result.add(windowEnd - windowStart + 1);
            // adjust windowStart  for next iteration.
            windowStart = windowEnd + 1;
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "aaaaaaaaaabccd";
        System.out.println(partitionLabels(s));
    }
}
