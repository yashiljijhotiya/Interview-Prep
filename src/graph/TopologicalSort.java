package graph;

import java.util.*;

public class TopologicalSort {

    private static List<Integer> topologicalSort(int edges[][], int vertices){
        List<Integer> sortedList = new ArrayList<>();
        if(edges == null || edges.length == 0){
            return null;
        }
        Map<Integer,Integer> degree = new HashMap<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        //Initialize graph
        for(int i = 0; i < vertices; i++){
            degree.put(i,0);
            adjList.put(i,new ArrayList<>());
        }

        //build graph
        for (int i = 0; i < edges.length; i++){
            int parent = edges[i][0], child = edges[i][1];
            adjList.get(parent).add(child); // put child into parent list
            degree.put(child, degree.get(child)+1); // increase the degree of child
        }

        //find all sources vertices
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : degree.entrySet()){
            if(entry.getValue() == 0){
                sources.add(entry.getKey());
            }
        }

        while (!sources.isEmpty()){
            int vertex = sources.poll();
            sortedList.add(vertex);
            List<Integer> children = adjList.get(vertex);
            for(int child: children){
                degree.put(child,degree.get(child)-1);
                if(degree.get(child) == 0){
                    sources.add(child);
                }
            }
        }

        if(sortedList.size() == 0){
            return new ArrayList<>();
        }

        return sortedList;
    }
    public static void main(String[] args) {
     int edges[][] = {{3,2},{3,0},{2,0},{2,1}};
        System.out.println(topologicalSort(edges,4));
    }

}
