package String;

import java.util.*;
import java.util.stream.Collectors;

//Hacker Rank
public class TwoCharacters {

    private static  void lenOfAlternate(String s){
        int freq[] = new int[128];
        int len = freq.length;
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)]++;
        }
        Arrays.sort(freq);
       int min = freq[len-2];
       int max = freq[len-1];
       int result = 0;
      if(max == min){
          result = 2*max;
      }
      else{
          result = 2*min +1;
      }
        System.out.println("longest string of two alternate character is :" + result);

    }

    private static int lenOfAlt(String s){
        int maxLen = 0;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            st.push(c1);
            for(int j = i+1; j < s.length(); j++){
                char c2 = s.charAt(j);
                if(st.size() == 1){
                    st.push(c2);
                }
                if(st.peek() != c2  && s.charAt(j) == c1 || s.charAt(j) == c2){
                    st.push(c2);
                }
            }
            
        }
        return maxLen;


    }

    public static void main(String[] args) {
     lenOfAlternate("beabeefeab");
    }
}
