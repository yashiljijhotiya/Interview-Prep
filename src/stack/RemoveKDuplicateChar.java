package stack;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Leetcode : 1209
 */
public class RemoveKDuplicateChar {

    private static String removeKAdjacentChar(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
                stack.push(1);
            } else {
                int count = stack.pop() + 1;
                if (count == k) {
                    sb.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    stack.push(count);
                }
            }
        }
        return sb.toString();
    }

    private static String removeAllDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        Collections.reverse(stack);
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        //  System.out.println(removeKAdjacentChar(s, 3));
        System.out.println(removeAllDuplicates("abbaca"));

    }
}
