package graph;
import java.util.Iterator;
import java.util.LinkedList;
public class GraphOperation {

    int vertex;
    LinkedList<Integer> adj[];

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


    public static void main(String[] args) {
        GraphOperation g = new GraphOperation(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("bfs of graph is:");
        g.bfs(2);
        System.out.println("dfs of graph is:");
        g.dfs(2);
    }
}
