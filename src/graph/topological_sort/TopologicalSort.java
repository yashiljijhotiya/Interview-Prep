package graph.topological_sort;

import java.util.*;

/**
 * Steps to be followed for  writing the topological sort for the DAG are
 * -> Initialize both adj list and in-degree map.
 * -> Build graph and find in-degree for all the vertices.
 * -> Find All the sources with in-degree 0 and add into the queue.
 * -> Now use BFS to traverse the
 * <p>
 * TC: O(V+E)
 * SC: O(V+E)
 */
public class TopologicalSort {

    private static List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        //initialize graph
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        //build graph
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            res.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if (res.size() != vertices) {
            return res;
        }
        return res;

    }

    public static void main(String[] args) {
        int vertex = 4;
        int[][] edges = {{3, 2}, {3, 0}, {2, 0}, {2, 1}};
        sort(vertex, edges).forEach(i -> System.out.println(i));
    }
}
