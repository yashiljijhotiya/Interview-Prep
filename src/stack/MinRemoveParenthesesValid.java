package stack;

import java.util.Stack;

public class MinRemoveParenthesesValid {
    private static int minRemoveRequired(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length(), min = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){

            }else {

            }
        }
        return min;
    }
    public static void main(String[] args) {

    }
}
