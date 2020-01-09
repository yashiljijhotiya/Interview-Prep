package String;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharacterByFreq {

    private static void sortByFreq(String str){
        HashMap<Character, Integer> hm = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>( (a,b) -> hm.get(b) - hm.get(a));
        for (int i = 0; i < str.length(); i++){
            char val = str.charAt(i);
            if(hm.containsKey(val)){
                hm.put(val, hm.get(val)+1);
            }
            else {
                hm.put(val, 1);
            }
        }
        pq.addAll(hm.keySet());
        StringBuilder s = new StringBuilder();
        while (!pq.isEmpty()){
            char val = pq.remove();
            for(int i = 0; i < hm.get(val); i++){
                s.append(val);
            }
        }
        System.out.println(s);
    }
    public static void main(String[] args) {
     String str = "tree";
     sortByFreq(str);
    }
}
