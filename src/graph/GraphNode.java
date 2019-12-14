package graph;

import java.util.LinkedList;

public class GraphNode {
    int vertex;
    LinkedList<Integer> adj[];

    GraphNode(int v){
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
         adj[i] = new LinkedList<>();
        }
    }




}
