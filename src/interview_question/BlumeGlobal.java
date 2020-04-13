package interview_question;

import java.util.HashSet;
import java.util.Set;

public class BlumeGlobal {
    private static final int MAX_CHAR = 26;

    private static int minWindow(String str){
        Set<Character> set = new HashSet<>();
        int max_len = Integer.MIN_VALUE, firstPtr = 0, secondPtr = 0;

        while(secondPtr < str.length()){
            if(!set.contains(str.charAt(secondPtr))){
                set.add(str.charAt(secondPtr));
                max_len = Math.max(max_len, set.size());
                secondPtr++;
            }
            else {
                set.remove(str.charAt(firstPtr));
                firstPtr++;
            }
        }
        System.out.println(str.substring(firstPtr,secondPtr));
        return max_len;

    }
    public static void main(String[] args) {
        System.out.println(minWindow("cccb"));
        System.out.println(minWindow("aabcada"));
        System.out.println(minWindow("aabcce"));
        System.out.println(minWindow("dabbcabcd"));
        System.out.println(minWindow("ABDEFGABEF"));
    }
}
