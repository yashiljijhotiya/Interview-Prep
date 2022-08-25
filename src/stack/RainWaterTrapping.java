package stack;

import java.util.Stack;

/**
 * Approach : Here approach followed is similar to max area of rectangle
 * The water get trap in the region where height of leftMax and rightMax are more than that region and water trap
 * can be calculated as min(leftHeight, rightHeight).
 **/
public class RainWaterTrapping {
    private static int findMaxWaterTrap(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int n = heights.length, maxWaterTrap = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (stack.size() > 0 && heights[stack.peek()] <= heights[i]) {
                int rightMax = i;
                int curr = heights[stack.pop()];
                if (stack.size() == 0)
                    break;
                int leftMax = stack.peek();
                int width = rightMax - leftMax - 1;
                maxWaterTrap += (Math.min(heights[leftMax], heights[rightMax]) - curr) * width;
            }
            stack.push(i);
        }
        return maxWaterTrap;
    }

    public static void main(String[] args) {
        int[] heights = {1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(findMaxWaterTrap(heights));
    }
}
