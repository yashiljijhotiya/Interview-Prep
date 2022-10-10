package stack;

import java.util.Arrays;
import java.util.Stack;

public class NGERight {
    private static int[] nextGreaterElmRight(int arr[]){
        Stack<Integer> stack = new Stack<>(); //{1,3,2,11,4,9,6};
        int n = arr.length;
        int nge[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while (stack.size() > 0 && stack.peek() < arr[i]){
                stack.pop();
            }
            nge[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(arr[i]);
        }
        return nge;
    }

    private static int[] nextSmallElmRight(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int nse[] = new int[n];
        for(int i = n-1; i >= 0; i--){
            while (stack.size() > 0 && stack.peek() >= arr[i]){
                stack.pop();
            }
            nse[i] = stack.size() > 0 ? stack.peek() : -1;
            stack.push(arr[i]);
        }
        return nse;
    }

    public static void main(String[] args) {
        int arr[] = {1,3,2,11,4,9,6};
        Arrays.stream(nextGreaterElmRight(arr)).forEach(i -> System.out.println(i));
        Arrays.stream(nextSmallElmRight(arr)).forEach(i -> System.out.println(i));
    }
}
