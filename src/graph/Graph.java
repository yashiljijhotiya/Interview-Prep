package graph;

import java.util.*;

public class Graph {

    HashMap<Integer, LinkedList<Integer>> g = new HashMap<>();


    public void addEdge(int src, int dst){
        if(!g.containsKey(src)){
            LinkedList<Integer> l = new LinkedList<>();
            l.add(dst);
            g.put(src,l);
        }
        else{
            LinkedList<Integer> l = g.get(src);
            l.add(dst);
            g.put(src,l);
        }
    }

    public void printGraph(){
        for(Map.Entry m : g.entrySet()){
            System.out.println(m.getKey()+ " --> "+m.getValue());
        }
    }

    public void bfs(int src, int node){
        Queue<Integer> q = new LinkedList<>();
        boolean arr[] = new boolean[node];
        arr[src] = true;
        q.add(src);
        while(!q.isEmpty()){
            int s = q.poll();
            System.out.println(" "+s);

        }
    }


    public static void main(String args[]){
        Graph g= new Graph();
        g.addEdge(0,1);
        g.addEdge(0,4);
        g.addEdge(0,5);
        g.addEdge(1,4);
        g.addEdge(1,3);
        g.addEdge(3,2);
        g.addEdge(2,1);
        g.addEdge(3,4);
        g.printGraph();

    }
}
