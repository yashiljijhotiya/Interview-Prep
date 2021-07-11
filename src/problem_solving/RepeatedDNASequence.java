package problem_solving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode: 187
public class RepeatedDNASequence {

    private static List<String> findRepeatedDNASequence(String s){
        List<String> result = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();
        int i = 0;
        while (i+10 <= s.length()){
            String sequence = s.substring(i, i++ + 10);
            freqMap.put(sequence, freqMap.getOrDefault(sequence, 0) +1);
            if(freqMap.get(sequence) == 2){
                result.add(sequence);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDNASequence(s).toString());
    }
}
