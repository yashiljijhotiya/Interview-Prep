package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Leetcode: 735
 */
public class AsteroidsCollision {

    /**
     * both are moving in same direction no collision
     * both are moving opposite direction collision
     */
    private static int[] asteroidCollision(int[] size) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size.length; i++) {
            int asteroid = size[i];
            //for any positive no. add it to stack
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // we have +ve no. on left and -ve no. ie current right is -ve and they will colloide
                //for handling +ve no. less than -ve
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                //push -ve no. coz moving in same direction
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
                // for handling equal val
                else if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                }
            }
        }
        int res[] = new int[stack.size()];
        for(int i = res.length -1; i >= 0 ; i--){
            res[i] = stack.pop();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] size = {-2, 10, -20, 5, 2, 1, -5}; // O/p: {-2,-20}
        Arrays.stream(asteroidCollision(size)).forEach(i -> System.out.println(i));

    }
}
