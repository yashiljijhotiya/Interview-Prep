package graph;
import java.util.*;

/* @Author : Yashil Jijhotiya
 *  @Date : 9 -04 -20
 * */

public class GraphOperation {

    int vertex;
    LinkedList<Integer> adj[];
    static  HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();

    GraphOperation(int v){
        vertex = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    private void addEdge(int src, int dst){
         adj[src].add(dst);
    }

    private void bfs(int s){
        boolean visited[] = new boolean[vertex];
        LinkedList<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()){
            s = q.poll();
            System.out.println(" "+ s);
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                   visited[n] = true;
                   q.add(n);
                }
            }
        }


    }

    private void dfs(int src){
        boolean visited [] = new boolean[vertex];
        dfsUtil(src,visited);
    }

    private void dfsUtil(int src, boolean visited[]){
        visited[src] = true;
        System.out.println(" " + src);
        Iterator<Integer> i = adj[src].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(! visited[n]){
               visited[n] = true;
               dfsUtil(n, visited);
            }
        }
    }

    private static  void addEdgeInHashMap(int src, int dst){
        if(graph.containsKey(src)){
            LinkedList<Integer> l = graph.get(src);
            l.add(dst);
            graph.put(src,l);
        }
        else{
            LinkedList<Integer> l = new LinkedList<>();
            l.add(dst);
            graph.put(src,l);
        }
    }

    private  static void displayGraph(){
        for(Map.Entry m : graph.entrySet()){
            System.out.println(m.getKey() + "--->" + m.getValue());
        }
    }


    private  static  void bfsHashMap(int src){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> seen = new HashSet<>();
        q.add(src);
        while(!q.isEmpty()){
            int vertex = q.poll();
            if(!seen.contains(vertex)){
                System.out.println(vertex);
                q.addAll(graph.get(src));
                seen.add(vertex);
            }
        }
    }


    public static void main(String[] args) {
        GraphOperation g = new GraphOperation(4);
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);
//        System.out.println("bfs of graph is:");
//        g.bfs(2);
//        System.out.println("dfs of graph is:");
//        g.dfs(2);
        g.addEdgeInHashMap(0, 1);
        g.addEdgeInHashMap(0, 2);
        g.addEdgeInHashMap(1, 2);
        g.addEdgeInHashMap(2, 0);
        g.addEdgeInHashMap(2, 3);
        g.addEdgeInHashMap(3, 3);
         displayGraph();
        bfsHashMap(0);
    }
}
