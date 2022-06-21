package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Graph basic problems
 */
public class GraphBasicProblems {

    /**
     * adjacency list representation of graph
     */
    private static Map<Integer, List<GNode>> graph;

    public GraphBasicProblems(int vertices) {
        graph = new HashMap<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    /**
     * function to initialize the graph
     */
    //{0,1,5}, {1,2,7},{0,3,2}, {2,3,8},{3,4,9}, {4,5,7}, {4,6,2}, {5,6,10}
    private static void buildGraph(int path[][]) {
        for (int i = 0; i < path.length; i++) {
            int src = path[i][0];
            int dest = path[i][1];
            int weight = path[i][1];
            GNode node = new GNode(src, dest, weight);
            graph.get(src).add(node);
        }
    }
    /** it will return if path exist*/
    private static boolean hasPath(int src, int dest, boolean[] isVisited) {
        if (src == dest) {
            return true;
        }
        List<GNode> edges = graph.get(src);
        isVisited[src] = true;
        for (GNode edge : edges) {
            if (!isVisited[edge.dst]) {
                boolean hasPath = hasPath(edge.dst, dest, isVisited);
                if (hasPath) {
                    return true;
                }
            }
        }
        return false;
    }

    /** it will return if graph is connected*/
    private static boolean isConnected(boolean [] isVisited, int vertices) {
        List<List<Integer>> graphComponents = getAllGraphs(vertices, isVisited);
        return graphComponents.size() == 1;
    }

    /** it will print all the paths from src to dest */
    private static void printAllPath(int src, int dest, boolean isVisited[], String pathVal){
        if(src == dest){
            System.out.println(pathVal);
            return;
        }
        List<GNode> edges = graph.get(src);
        isVisited[src] = true;
        for (GNode edge : edges){
            if(!isVisited[edge.dst]){
                printAllPath(edge.dst, dest, isVisited, pathVal+edge.dst);
            }
        }
        isVisited[src] = false;
    }

    /**it will print the path sum */
    private static void printPathSum(int src, int dest, boolean [] isVisited, String path, int pathSum){
        if(src == dest){
            System.out.println("Path sum for path " + path +" : "+ pathSum);
            return;
        }
        List<GNode> edges = graph.get(src);
        isVisited[src] = true;
        for(GNode edge : edges){
            if(!isVisited[edge.dst]){
                printPathSum(edge.dst, dest, isVisited, path+edge.dst, pathSum+edge.weight);
            }
        }
        isVisited[src] = false;

    }

    /** it will return list of all the graphs */
    private static List<List<Integer>> getAllGraphs(int vertices, boolean isVisited[]){
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < vertices; i++){
            if(!isVisited[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                getAllGraphsUtil(i, isVisited, comp);
                result.add(comp);
            }
        }
        return result;
    }

    private static void getAllGraphsUtil(int src, boolean [] isVisited, List<Integer> comp){
        isVisited[src] = true;
        comp.add(src);
        List<GNode> edges = graph.get(src);
        for(GNode edge : edges){
            if(!isVisited[edge.dst]){
                getAllGraphsUtil(edge.dst, isVisited, comp);
            }
        }
    }

    public static void main(String[] args) {
        int[][] path = {{0, 1, 5}, {1, 2, 7}, {0, 3, 2}, {2, 3, 8}, {3, 4, 9}, {4, 5, 7}, {4, 6, 2}, {5, 6, 10}};
        int vertices = 7;
        boolean[] isVisited = new boolean[7];
        GraphBasicProblems graphBasicProblems = new GraphBasicProblems(7);
        buildGraph(path);
        int src = 0, dest = 6;
       // System.out.println("have path from src : "+ src + "and dest : "+ dest +" : "+ hasPath(src,dest, isVisited));
        //printAllPath(src, dest,isVisited, src+"");
        //printPathSum(src, dest, isVisited, src+"", 0);

        System.out.println(getAllGraphs(vertices,isVisited));
    }
}
