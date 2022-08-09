package graph;

public class MaxAreaOfIsland {

    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int findMaxArea(int[][] islands) {
        int maxArea = 0;
        if (islands == null || islands.length == 0) {
            return 0;
        }
        int m = islands.length, n = islands[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (islands[i][j] == 1) {
                    int area = 0;
                    dfs(islands, m, n, i, j, area);
                    maxArea = Integer.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }


    private static void dfs(int[][] islands, int m, int n, int i, int j, int area) {
        if (i < 0 || j < 0 || i >= m || j >= n || islands[i][j] == 0) {
            return;
        }
        islands[i][j] = 0;
        area++;
        for (int dir[] : directions) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            dfs(islands, m, n, x, y, area);
        }
    }
}
