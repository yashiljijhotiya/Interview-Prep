package graph.bfs;

import java.util.*;

public class FindPathExist {
    private static boolean isPathExist(int[][] edges, int n, int src, int dest) {
        if (src == dest) {
            return true;
        }
        if (edges == null || edges.length == 0) {
            return false;
        }
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        q.add(src);
        isVisited[src] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            if (v == dest) {
                return true;
            }
            for (int node : graph.get(v)) {
                if (!isVisited[node]) {
                    q.add(node);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int src = 0, dest = 5, n = 6;
        System.out.println(src + " is path exist b/w " + dest + " : " + isPathExist(edges, n, src, dest));
    }
}
