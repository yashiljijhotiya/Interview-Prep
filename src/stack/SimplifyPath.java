package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Leetcode: 71
 **/
public class SimplifyPath {
    private static String simplifyPath(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] splitPath = s.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String path : splitPath) {
            if (stack.size() > 0 && "..".equals(path)) {
                stack.pop();
            } else if (!Arrays.asList("", ".").contains(path)) {
                stack.push(path);
            }
        }
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String s = "/a/./b/../../c";
        System.out.println(simplifyPath(s));
    }
}
