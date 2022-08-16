package stack;

import java.util.Stack;

/**
 * Leetcode: 503
 * Algo:
 * - Start processing element from n-2
 * - And we perform 2 operations push and pop
 * - after that loop again from n-1 to get all elements NGE from stack
 **/
public class NGECyclicOrder {
    private static int[] findNGEInCyclicArr(int arr[]) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 2; i >= 0; i--) {
            //+-
            while (stack.size() > 0 && arr[i] >= stack.peek()) {
                stack.pop();
            }
            stack.push(arr[i]);
        }
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(arr[i]);
        }
        return nge;
    }

    public static void main(String[] args) {
        int arr[] = {3, 8, 4, 1, 2};
    }
}
