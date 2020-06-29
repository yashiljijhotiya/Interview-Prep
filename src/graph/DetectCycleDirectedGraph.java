package graph;

import java.util.*;

public class DetectCycleDirectedGraph {

    private static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    private static boolean hasCycle(int mat[][], int vertices){

        Set<Integer> whiteSet = new HashSet<>();
        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();
        //build graph
        buildGraph(mat,4);

        //initially add all vertices to white set
        for(int i = 0; i < vertices; i++){
            whiteSet.add(i);
        }

        while(whiteSet.size() > 0){
            int currVertex = whiteSet.iterator().next();
            if(dfs(currVertex,whiteSet,greySet,blackSet)){
                return true;
            }
        }
        return false;
    }

    private static boolean dfs(int vertex, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet){

        greySet.add(vertex);
        for(int neighbor : adjList.get(vertex)){
            if(blackSet.contains(neighbor)){
                continue;
            }
            if(greySet.contains(neighbor)){
                return true;
            }
            if(dfs(neighbor,whiteSet,greySet,blackSet)){
               return true;
            }
        }

        return true;
    }


    private static void buildGraph(int mat[][],int vertices){
        //initialize graph
        for(int i = 0; i < vertices;i++){
            adjList.put(i,new ArrayList<>());
        }
        //build graph
        for(int [] g : mat){
            int parent = g[0];
            int child = g[1];
            adjList.get(parent).add(child);
        }

    }

    public static void main(String[] args) {
        int [][] mat = {{0,1}, {0,2}, {1,2}, {2,0},{2,3},{3,3}};

    }
}
