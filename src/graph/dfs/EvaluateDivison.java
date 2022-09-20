package graph.dfs;

import java.util.*;

/**
 * Leetcode: 399
 * TC: Q*(V+E) Here Q = no. of queries, V = no. of vertices, E = no. of edges,
 * SC: O(V+E)
 */
public class EvaluateDivison {

    private static class Node {
        String key;
        double val;

        Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    private static double[] calcEquation(List<List<String>> equations, double[] val, List<List<String>> queries) {
        int size = queries.size();
        double[] res = new double[size];
        Map<String, List<Node>> graph = buildGraph(equations, val);
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return res;
    }

    private static double dfs(String src, String dest, Set<String> visited, Map<String, List<Node>> graph) {
        if (!graph.containsKey(src) && !graph.containsKey(dest)) {
            return -1.0;
        }
        if (src.equals(dest)) {
            return 1.0;
        }
        visited.add(src);
        for (Node neighbor : graph.get(src)) {
            if (!visited.contains(neighbor.key)) {
                double ans = dfs(neighbor.key, dest, visited, graph);
                if (ans != -1) {
                    return ans * neighbor.val;
                }
            }
        }
        return -1.0;
    }

    private static Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] val) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < val.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(src).add(new Node(dest, val[i]));
            graph.get(dest).add(new Node(src, 1 / val[i]));
        }
        return graph;
    }

    public static void main(String[] args) {
        List<List<String>> eq = new ArrayList<>();
        eq.add(Arrays.asList(new String[]{"a", "b"}));
        eq.add(Arrays.asList(new String[]{"b", "c"}));
        double[] val = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new String[]{"a", "c"}));
        queries.add(Arrays.asList(new String[]{"b", "a"}));
        queries.add(Arrays.asList(new String[]{"a", "e"}));
        queries.add(Arrays.asList(new String[]{"a", "a"}));
        queries.add(Arrays.asList(new String[]{"x", "x"}));
        double[] res = calcEquation(eq, val, queries);
        Arrays.stream(res).forEach(i -> System.out.println(i));

    }
}
