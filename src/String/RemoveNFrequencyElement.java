package String;

import java.util.HashMap;
import java.util.Iterator;

public class RemoveNFrequencyElement {

    private static  void removeNthFrequencyElem(String str, int freq){
        HashMap<Character, Integer> hmap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(!hmap.containsKey(str.charAt(i))){
                hmap.put(str.charAt(i),0);
            }
            else{
                hmap.put(str.charAt(i), hmap.get(str.charAt(i))+1);
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            if(hmap.get(str.charAt(i)) < freq){
                result =  result.append(str.charAt(i));
            }
        }
        System.out.println(hmap);
        System.out.println(result);
    }

    public static void main(String[] args) {
        String str = "testtagleasttest";
        removeNthFrequencyElem(str, 2);
    }
}
