package stack;

import java.util.Stack;

/**
 * Leetcode:394
 * we have to keep 3 things in mind by seeing the i/p string i.e. it contains digit first than open bracket
 * than alphabet than close bracket
 */
public class EncodedString {

    private static String decodeString(String s) {
        Stack<Integer> digitStack = new Stack<>();
        Stack<String> characterStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                //eg 15 -> 1*10 + (5 - '0') = 10 + 5 = 15
                num = num * 10 + (c - '0');// conversion of character to digit char '0' ascii val is 48 and '1' is 49 so 49 - 48 = 1
            } else if (Character.isLetter(c)) {
                sb.append(c);
            } else if (c == '[') {
                digitStack.add(num);
                characterStack.add(sb.toString());
                num = 0;
                sb = new StringBuilder();
            } else {
                int count = digitStack.pop();
                StringBuilder repeatedWord = new StringBuilder(characterStack.pop());
                for (int i = 1; i <= count; i++) {
                    repeatedWord.append(sb);
                }
                sb = repeatedWord;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //Test cases
        String s1 = "3[a]2[bc]";//aaabcbc
        String s2 = "3[a2[c]]"; //accaccacc
        String s3 = "2[abc]3[cd]ef";//abcabccdcdcdef
        System.out.println(decodeString(s1));
        System.out.println(decodeString(s2));
        System.out.println(decodeString(s3));
    }
}
