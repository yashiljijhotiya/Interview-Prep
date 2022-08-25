package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode: 797
 */
public class FindAllPath {
    private static List<List<Integer>> findAllPaths(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return res;
        }
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        q.add(path);
        while (!q.isEmpty()) {
            List<Integer> currPath = q.poll();
            int node = currPath.get(currPath.size() - 1);
            for (int nextNode : graph[node]) {
                List<Integer> tempPath = new ArrayList<>(currPath);
                tempPath.add(nextNode);
                if (nextNode == graph.length - 1) {
                    res.add(new ArrayList<>(tempPath));
                } else {
                    q.add(new ArrayList<>(tempPath));
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {3}, {3}, {}};

    }
}
