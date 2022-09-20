package graph.dfs;

/**
 * Leetcode: 329
 * TC: O(m*n)
 * SC: O(m*n)
 */
public class LongestIncreasingPathMatrix {
    private static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int findLongestIncreasingPath(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return 0;
        }
        int r = mat.length, c = mat[0].length, longestPath = 0;
        Integer dp[][] = new Integer[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int path = dfs(mat, i, j, r, c, dp);
                longestPath = Math.max(path, longestPath);
            }
        }
        return longestPath;
    }

    private static int dfs(int[][] mat, int i, int j, int r, int c, Integer dp[][]) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int max = 0;
        for (int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if (x >= 0 && x < r && y >= 0 && y < c && mat[x][y] > mat[i][j]) {
                max = Math.max(dfs(mat, x, y, r, c, dp), max);
            }
        }
        dp[i][j] = max + 1;
        return max + 1;

    }

    public static void main(String[] args) {
        int mat[][] = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(findLongestIncreasingPath(mat));
    }
}
