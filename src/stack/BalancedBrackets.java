package stack;

import java.util.Stack;

public class BalancedBrackets {

    private static boolean isBalanced(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!handleClosingBrackets(stack, '(')) {
                    return false;
                }

            } else if (c == ']') {
                if (!handleClosingBrackets(stack, '[')) {
                    return false;
                }
            } else if (c == '}') {
                if (!handleClosingBrackets(stack, '{')) {
                    return false;
                }
            }

        }
        return stack.size() == 0;
    }

    private static boolean handleClosingBrackets(Stack<Character> stack, char correspondingOpeningChar) {
        if (stack.size() == 0) {
            return false;
        } else if (stack.peek() != correspondingOpeningChar) {
            return false;
        } else {
            stack.pop();
            return true;
        }
    }

    public static void main(String[] args) {
        String s = "[(a+b)+{(c+d)*(e/f)}]}";
        System.out.println(isBalanced(s));

    }
}
