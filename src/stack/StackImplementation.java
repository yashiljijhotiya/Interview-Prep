package stack;

import java.util.ArrayList;
import java.util.List;

public class StackImplementation {
    private List<Integer> stack;

    StackImplementation() {
        stack = new ArrayList<>();
    }

    private void push(int val) {
        stack.add(val);
        System.out.println("element pushed successfully in the stack :" + val);
    }

    private boolean isEmpty() {
        return stack.isEmpty();
    }

    private int peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        }
        return -1;
    }

    private int pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        }
        return -1;
    }


    public static void main(String[] args) {
        StackImplementation stackImplementation = new StackImplementation();
        stackImplementation.push(1);
        stackImplementation.push(2);
        stackImplementation.push(3);

    }
}
