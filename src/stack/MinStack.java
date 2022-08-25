package stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    private void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    private void pop() {
        if (stack.isEmpty() && minStack.isEmpty() && stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    private int top() {
        return stack.peek();
    }

    private int getMin() {
        return minStack.peek();
    }

}
