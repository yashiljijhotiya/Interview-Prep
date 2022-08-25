package graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPath {
    private static final int[][] directions =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private static int findShortestPath(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        if (grid[0][0] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        // queue storing array of size 3 which have X-Cord, Y-Cord, length of path
        q.add(new int[]{0, 0, 1});
        while (!q.isEmpty()) {
            int[] pair = q.poll();
            int x = pair[0];
            int y = pair[1];
            int len = pair[2];
            if (x == grid.length - 1 && y == grid[0].length - 1) {
                return len;
            }
            for (int dir[] : directions) {
                int dx = x + dir[0];
                int dy = y + dir[1];
                if (dx < 0 || dy < 0 || dx >= grid.length || dy >= grid[0].length) {
                    continue;
                }
                if (grid[dx][dy] != 0) {
                    continue;
                }
                q.add(new int[]{dx, dy, len + 1});
                grid[dx][dy] = 1;
            }
            grid[x][y] = 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][] grid = {{0,0,0}, {1,1,0}, {1,1,0}};
        System.out.println(findShortestPath(grid));

    }
}
