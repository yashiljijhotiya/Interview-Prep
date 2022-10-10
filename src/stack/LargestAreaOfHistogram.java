package stack;

import java.util.Stack;

public class LargestAreaOfHistogram {
    private static int findMaxArea(int[] area) {
        if (area == null || area.length == 0) {
            return 0;
        }
        int n = area.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int[] rb = new int[n];// right boundary storing right next smaller element index
        stack.push(n - 1);
        rb[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            while (stack.size() > 0 && area[i] < stack.peek()) {
                stack.pop();
            }
            if (stack.size() == 0) {
                rb[i] = n;

            } else {
                rb[i] = stack.peek();
            }
            stack.push(i);
        }

        int[] lb = new int[n];//left boundary storing left next smaller element index
        stack.push(0);
        lb[0] = -1;
        for (int i = 1; i < n; i++) {
            while (stack.size() > 0 && area[i] < stack.peek()) {
                stack.pop();
            }
            if (stack.size() == 0) {
                lb[i] = -1;

            } else {
                lb[i] = stack.peek();
            }
            stack.push(i);
        }


        for (int i = 0; i < n; i++) {
            int width = rb[i] - lb[i] - 1;
            int ar = width * area[i];
            if (maxArea < ar) {
                maxArea = ar;
            }
        }

        return maxArea;
    }

    //optimized soln
    private static int findLargestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        /**
         *  - pop bigger val from stack
         *  - make ans
         *  - push curr val in stack
         * */
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currVal = i == heights.length ? 0 : heights[i];
            while (stack.size() > 0 && stack.peek() != -1 && heights[stack.peek()] >= currVal) {
                int rm = i;
                int height = heights[stack.pop()];
                int lm = stack.peek();
                maxArea = Math.max(maxArea, (rm - lm - 1) * height);

            }
            //pushing curr index
            stack.push(i);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] area = {6, 2, 5, 4, 1, 6};
        System.out.println(findLargestRectangleArea(area));

    }
}
