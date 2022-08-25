package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Leetcode: 1762
 **/
public class BuildingWithOceanView {

    private static int[] findBuildings(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            if (heights[stack.peek()] < heights[i]) {
                stack.push(i);
            }
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] heights = {1, 5, 2, 4};
        int[] res = findBuildings(heights);
        Arrays.stream(res).forEach(i -> System.out.println(i));

    }
}
