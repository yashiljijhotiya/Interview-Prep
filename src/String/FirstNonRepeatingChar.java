package String;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    private static char firstNonRepeatingChar(String str){
        if(str == null || str.length() == 0){
            return ' ';
        }
        char res = ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c) && map.get(c) == 1){
                res = c;
                break;
            }
        }

        return res;
    }
    public static void main(String[] args) {
        String str = "abccbd";
        System.out.println("first non repeating char is :" + firstNonRepeatingChar(str));
    }
}
