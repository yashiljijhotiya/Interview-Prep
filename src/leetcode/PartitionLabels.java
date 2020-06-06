package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* */
public class PartitionLabels {

    private static List<Integer> partitionLabels(String S){
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            freq.put(S.charAt(i), i);
        }

        List<Integer> result = new ArrayList<>();
        int maxIndex = freq.get(S.charAt(0));
        int j = 0;
        while (j < S.length()) {
            int start = j;
            maxIndex = freq.get(S.charAt(start));
            while (j < maxIndex) {
                maxIndex = Math.max(maxIndex, freq.get(S.charAt(j++)));
                j++;
            }
            result.add(maxIndex - start + 1);
            j = maxIndex + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
