package sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubStringWithWordConcatenation {

    private static List<Integer> findSubString(String str, String [] words){
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> wordMap = new HashMap<>();
        int wordsCount = words.length, wordLen = words[0].length();
        for(String word : words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) +1);
        }

        for(int i = 0; i <= str.length() - wordsCount*wordLen; i++){
            HashMap<String, Integer> seenMap = new HashMap<>(wordMap);
            for(int j = 0; j < words.length; j++){
                String s = str.substring(i + j*wordLen, i + j*wordLen + wordLen);

            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
