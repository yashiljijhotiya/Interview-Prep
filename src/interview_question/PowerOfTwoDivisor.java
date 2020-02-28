package interview_question;

import java.util.HashMap;

public class PowerOfTwoDivisor {

    public static void main(String[] args) {
      String s = "aaabbb";
      String s1 = s.substring(0,s.length()/2);
      String s2 = s.substring(s.length()/2, s.length());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(0%2);
        HashMap<Character, Integer> map = new HashMap<>();
        char charArr[] = s.toCharArray();
        for(char ch : charArr){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        System.out.println(map);

    }
}
