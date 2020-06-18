package design;

import java.util.Stack;

public class QueueUsingStack {
    private static Stack<Integer> stack;
    private static Stack<Integer> tempStack;

    public QueueUsingStack(){
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    private static void push(int val){
     while(!stack.isEmpty()){
         tempStack.push(stack.pop());
     }

     tempStack.push(val);

     while(!tempStack.isEmpty()){
         stack.push(tempStack.pop());
     }

    }

    private static int pop(){
        if(stack.isEmpty()){
            return -1;
        }
        else {
            return stack.pop();
        }
    }

    private static int peek(){
        if(stack.isEmpty()){
            return -1;
        }
        else {
            return stack.peek();
        }
    }

    private static boolean isEmpty(){
        return stack.isEmpty();
    }

}
