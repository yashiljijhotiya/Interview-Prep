package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CriticalConnections {

    private static int time;
    private static boolean visited[];
    private static int lowTime [];
    private static int visitedTime[];
    private static HashMap<Integer, List<Integer>> adjList = new HashMap<>();

    private static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections){

        time = 0;
        visited = new boolean[n];
        lowTime = new int[n];
        visitedTime = new int[n];
        List<List<Integer>> result = new ArrayList<>();
        buildGraph(connections);
        dfs(result,1,-1);

        return result;
    }

    private static void dfs(List<List<Integer>> result, int root, int parent){

        lowTime[root] = time;
        visitedTime[root] = time;
        time++;
        visited[root] = true;
        for(int children : adjList.get(root)){
            if(parent == children){
                continue;
            }
            if(visited[children]){
                lowTime[root] = Math.min(lowTime[root],visitedTime[children]);
            }
            else {
                dfs(result,children, root);
                lowTime[root] = Math.min(lowTime[root], lowTime[children]);
                if(lowTime[children] > visitedTime[root]){
                    List<Integer> list = new ArrayList<>();
                    list.add(root);
                    list.add(children);
                    result.add(list);
                }
            }
        }
    }

    private static void buildGraph(List<List<Integer>> connections){
        for(List<Integer> connection : connections){
            int node1 = connection.get(0);
            int node2 = connection.get(1);
            if(!adjList.containsKey(node1)){
                adjList.put(node1,new ArrayList<>());
            }
            if(!adjList.containsKey(node2)){
                adjList.put(node2, new ArrayList<>());
            }
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> connections = new ArrayList<>();
        List<Integer> n1 = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();
        List<Integer> n3 = new ArrayList<>();
        List<Integer> n4 = new ArrayList<>();
        n1.add(0);
        n1.add(1);
        n2.add(1);
        n2.add(2);
        n3.add(2);
        n3.add(0);
        n4.add(1);
        n4.add(3);
        connections.add(n1);
        connections.add(n2);
        connections.add(n3);
        connections.add(n4);
        System.out.println(criticalConnections(4, connections));
    }
}
