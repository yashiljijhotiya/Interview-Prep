package stack;

import java.util.Stack;

public class NGELeft {
    private static int[] nextGreaterElmLeft(int arr[]) {
        int n = arr.length;
        int nge[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(arr[i]);
        }
        return nge;
    }

    private static int[] nextSmallerElmLeft(int arr[]) {
        int n = arr.length;
        int nse[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && stack.peek() >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(arr[i]);
        }
        return nse;
    }

    public static void main(String[] args) {

    }
}
