package stack;

import java.util.Collections;
import java.util.Stack;

public class BalancedParentheses {

    private static boolean isMatching(char a, char b){
        if(a == '(' && b == ')'){
            return true;
        }
        else if(a == '{' && b == '}'){
            return true;
        }
        else if(a == '(' && b == ')'){
            return true;
        }
        else
            return false;
    }


    private static boolean isBalanced(char arr[]){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '{' || arr[i] == '[' || arr[i] == '('){
                stack.push(arr[i]);
            }
            else if(arr[i] == '}' || arr[i] == ']' || arr[i] == ')'){
                if(stack.isEmpty()){
                    return false;
                }
                else if(!isMatching(stack.pop(), arr[i])){
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        char exp[] = {'{','(',')','}','[',']'};
        if (isBalanced( exp))
            System.out.println("Balanced ");
        else
            System.out.println("Not Balanced ");


    }
}
