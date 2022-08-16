package stack;

import java.util.Stack;

public class StockSpan {
    private static int[] findStocksSpan(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            while (stack.size() > 0 && arr[i] >= arr[stack.peek()]) {
                stack.pop();
            }
            if (stack.size() == 0) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }
            stack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        int[] arr = {};
    }
}
