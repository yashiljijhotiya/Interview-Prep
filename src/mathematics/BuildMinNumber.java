package mathematics;

import java.util.Stack;

/*Leetcode
remove k numbers
TC : O(n)
hill peak
* */
public class BuildMinNumber {

    private static String buildMinNo(String num, int k){
        int size = num.length();
        if(size <= k){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        int counter = 0;
        while(counter < size){
            while(k > 0 && counter < size && !stack.isEmpty() && stack.peek() > num.charAt(counter)){
                stack.pop();
                k -= 1;
            }
            stack.push(num.charAt(counter++));
        }

        while(k > 0){
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();

        while(stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0'){
            stringBuilder.deleteCharAt(0);
        }

        return stringBuilder.toString();

    }
    public static void main(String[] args) {
        System.out.println(buildMinNo("1432219",3));
        System.out.println(buildMinNo("1001", 1));
    }
}
