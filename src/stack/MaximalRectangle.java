package stack;

import java.util.Stack;

/**
 * Leetcode: 85
 * To find the max area of rectangle formed by binary matrix formed from 1
 */
public class MaximalRectangle {
    private static int findMaxArea(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxArea = 0, r = arr.length, c = arr[0].length;
        int heights[] = new int[c];
        //to copy the first row as it is
        for (int i = 0; i < c; i++) {
            heights[i] = arr[0][i];
        }
        maxArea = findLargestRectangleArea(heights);
        // now calculating height from row no. 1
        for (int i = 1; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == 1) {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, findLargestRectangleArea(heights));
        }
        return maxArea;
    }

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
        int[][] arr = {{0, 1, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {1, 1, 1, 0, 1}};

        System.out.println(findMaxArea(arr));

    }
}
