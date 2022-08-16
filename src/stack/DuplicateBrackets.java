package stack;

import java.util.Stack;

public class DuplicateBrackets {

    private static boolean isDuplicatePresent(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                //In case ((a+b)) the outer bracket does not contains any content so it's duplicate bracket condition
                if (stack.peek() == '(') {
                    return false;
                } else {
                    while (stack.peek() != '(') {
                        stack.pop();
                    }
                    //to remove extra bracket
                    stack.pop();
                }
            } else {
                //push everything in stack except the closing bracket
                stack.push(c);
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        String s1 = "(a+b)+((c+d))";
        String s2 = "((a+b) + (c+d))";
        System.out.println(isDuplicatePresent(s1));
        System.out.println(isDuplicatePresent(s2));

    }
}
