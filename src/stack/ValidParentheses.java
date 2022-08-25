package stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> charMap = new HashMap<>();
        charMap.put(')', '(');
        charMap.put('}', '{');
        charMap.put(']', '[');
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                char currChar = stack.isEmpty() ? '*' : stack.pop();
                if (currChar != charMap.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
