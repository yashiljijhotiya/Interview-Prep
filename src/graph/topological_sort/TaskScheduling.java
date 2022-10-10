package graph.topological_sort;

import java.util.*;
/**
 * TC: O(V+E)
 * */
public class TaskScheduling {

    private static List<Integer> findOrder(int task, int[][] prerequisite) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        //intialize graph
        for (int i = 0; i < task; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        // build graph

        for (int[] pre : prerequisite) {
            int parent = pre[0];
            int child = pre[1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            res.add(vertex);
            List<Integer> children = graph.get(vertex);
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int noOfTask = 4;
        int[][] prerequisite = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        findOrder(noOfTask, prerequisite).forEach(i -> System.out.println(i));
    }

}
