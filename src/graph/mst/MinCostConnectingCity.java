package graph.mst;

import java.util.*;

/**
 * Leetcode: 1135
 */
public class MinCostConnectingCity {
    private static class Pair {
        int src;
        int nbr;
        int wt;

        Pair(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private static int findMinCost(int[][] connections, int n) {
        if (connections == null || connections.length == 0) {
            return 0;
        }
        Map<Integer, List<int[]>> graph = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        for (int[] con : connections) {
            int node1 = con[0];
            int node2 = con[1];
            int wt = con[2];
            graph.computeIfAbsent(node1, (k) -> new ArrayList<>());
            graph.computeIfAbsent(node2, (k) -> new ArrayList<>());
            graph.get(node1).add(new int[]{node2, wt});
            graph.get(node2).add(new int[]{node1, wt});
        }

        pq.add(new Pair(1, 1, 0));
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (!visited.contains(p.nbr)) {
                cost += p.wt;
                visited.add(p.nbr);
                for (int next[] : graph.get(p.nbr)) {
                    pq.add(new Pair(p.nbr, next[0], next[1]));
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        int[][] cost = {{1, 2, 5}, {1, 3, 6}, {2, 3, 1}};
        int n = 3;
        System.out.println(findMinCost(cost, 3));
    }
}
