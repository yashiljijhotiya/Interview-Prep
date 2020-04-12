package graph;

import java.util.*;

/* @Author : Yashil Jijhotiya
*  @Date : 10 - 04 - 20
*  Basic graph operations like create graph, add new edge, traversal bfs, dfs, Kruskals MST.
* */


public class GraphProblems {

    private static Map<Integer, List<GNode>>graph = new HashMap<>();

    private static void addEdge(int src, int dst){
        GNode gNode = new GNode(src,dst);
        List<GNode> nodeList;
        if(!graph.containsKey(src)){
            nodeList = new ArrayList<>();
        }
        else{
            nodeList = graph.get(src);
        }
        nodeList.add(gNode);
        graph.put(src,nodeList);
    }

    private static void bfs(GNode src){
        Queue<GNode> queue = new LinkedList<>();
        src.isVisited = true;
        queue.add(src);

        while(!queue.isEmpty()){
            GNode gNode = queue.poll();
            System.out.println(gNode.src);

            List<GNode> nodeList = graph.get(src);
            for(GNode node : nodeList){
                if(!node.isVisited){
                    node.isVisited = true;
                    queue.add(node);
                }
            }
        }
    }

    public static void main(String[] args) {
        addEdge(0,1);
        addEdge(0,2);
        addEdge(2,3);
        addEdge(3,4);
    }
}
