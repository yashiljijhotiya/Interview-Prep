package String;

import java.util.*;

public class AnagramProblems {

    private static void groupAnagram(String str[]){
        Map<String, List<String>> freqMap = new HashMap<>();
        for(String s : str) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String sortedWord = new String(word);
            if(!freqMap.containsKey(word)){
                List<String> list = new ArrayList<>();
                list.add(s);
                freqMap.put(sortedWord,list);
            }
            else{
                freqMap.get(sortedWord).add(s);
            }
        }

        for(String s: freqMap.keySet()){
            List<String> list = freqMap.get(s);
            if(list.size() > 0){
                System.out.println(list);
            }
        }
    }

    public static void main(String[] args) {
        String str[] = {"cat", "act", "dog", "tac", "god"};
        groupAnagram(str);
    }
}
