package stack;

import java.util.Stack;

public class MinAddParenthesesValid {

    private static int minValidParenthesesRequired(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(c);
            }else {
                if(stack.size() > 0 && stack.peek() == '('){
                    stack.pop();
                }else {
                    stack.push(c);
                }
            }
        }
        return stack.size();

    }
    public static void main(String[] args) {
        String s = "(()))())";
        System.out.println(minValidParenthesesRequired(s));

    }
}
