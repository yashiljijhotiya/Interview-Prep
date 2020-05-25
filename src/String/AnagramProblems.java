package String;

import java.util.*;
/*Leetcode
TC : o(n*log(n))
SC : o(n)
* */
public class AnagramProblems {

    private static void groupAnagram(String str[]){
        Map<String, List<String>> freqMap = new HashMap<>();
        for(String s : str) {
            char[] word = s.toCharArray();
            Arrays.sort(word);
            String sortedWord = new String(word);
            if(!freqMap.containsKey(sortedWord)){
                List<String> list = new ArrayList<>();
                list.add(s);
                freqMap.put(sortedWord,list);
            }
            else{
                freqMap.get(sortedWord).add(s);
            }
        }


        for(Map.Entry<String, List<String>> entry : freqMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }

    public static void main(String[] args) {
        String str[] = {"cat", "act", "dog", "tac", "god"};
        groupAnagram(str);
    }
}
