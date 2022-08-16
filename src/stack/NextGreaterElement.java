package stack;

import java.util.Arrays;
import java.util.Stack;
/**
 * TC: O(n)
 * */
public class NextGreaterElement {
    private static int[] printNGE(int arr[]) {
        if (arr == null || arr.length == 0) {
            return new int[1];
        }
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        stack.push(arr[n - 1]);
        nge[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            // POP until element greater not found, Ans, PUSH
            while (stack.size() > 0 && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 9, 3, 1, 12, 6, 8, 7};
        int [] nge = printNGE(arr);
        Arrays.stream(nge).forEach(i -> System.out.println(i));
    }
}
