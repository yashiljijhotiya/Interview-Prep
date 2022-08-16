package stack;

import java.util.Stack;

/**
 * I/P          O/P
 * "()"    ->   ""
 * "(())"  ->   "()"
 * "()()"  ->   ""
 * Approach:
 * - Split the string  "(()())()" -> "(()()) + ()"
 * - remove outermost  "()()"
 * - Merge the final result "()()"
 */
public class RemoveOutermostParentheses {
    private static String removeOutermostParentheses(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //If stack size is greater than zero than the bracket processing is not outermost
                if (stack.size() > 0) {
                    //adding it to answer
                    sb.append(c);
                }
                stack.push(c);
            } else {
                stack.pop();
                // stack contains non outermost add it to ans
                if (stack.size() > 0) {
                    sb.append(c);
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "(())(()())";
        System.out.println(removeOutermostParentheses(s));

    }
}
