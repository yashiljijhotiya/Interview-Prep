package String;

import collections.HashMapOperation;

import java.util.HashMap;
import java.util.TreeMap;

public class CountSequenceAlphabet {

    private static void countAlphabet(String str){
        int c = 1;
        String result = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == str.charAt(i+1)){
                ++c;
            }
            else{
                result += str.charAt(i)+ Integer.toString(c)+ ",";
                c = 1;
            }
        }
        System.out.print(result);
    }

    private static  void countKthRepeatedWord(String str){
        HashMap<String, Integer> h = new HashMap<>();
        for(String s : str.split(" ")){
            if(h.containsKey(s)){
                h.put(s, h.get(s)+1);
            }
            else {
                h.put(s, 1);
            }
        }

        TreeMap<Integer, String> tm = new TreeMap<>();
        for(String word : h.keySet()){
            tm.put(h.get(word),word);
        }

    }
    public static void main(String[] args) {
      String str = " aaabbddaabbcc";
      String s = "abc ddd abc test abc ddd test";

      //countAlphabet(str);
    }
}
