package graph.union_find;

import java.util.Arrays;

/**
 * Leetcode: 684
 * TC: O(N)
 * SC: O(N)
 */
public class RedundantConnection {
    private static int[] parent;

    private static int[] findRedundantConnections(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }
        int n = edges.length;
        unionFind(n);
        for (int[] edge : edges) {
            //parentX == parentY i.e. they are forming a cycle
            if (find(edge[0]) == find(edge[1])) {
                return edge;
            }
            union(edge[0], edge[1]);
        }
        int[] res = new int[2];
        return res;
    }

    private static void unionFind(int size) {
        parent = new int[size + 1];
        for (int i = 0; i <= size; i++) {
            parent[i] = i;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if (parentX != parentY) {
            parent[parentY] = parentX;
        }
    }


    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] res = findRedundantConnections(edges);
        Arrays.stream(res).forEach(i -> System.out.println(i));
    }
}
