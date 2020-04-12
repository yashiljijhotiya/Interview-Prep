package disjoint_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectCycleUndirectedGraph {

    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static Map<Integer, Integer> parent = new HashMap<>();
    private static Map<Integer, Integer> rank = new HashMap<>();

    private static void addEdge(int src, int dst){
        if(!graph.containsKey(src)){
            List<Integer> list = new ArrayList<>();
            list.add(dst);
            graph.put(src,list);
        }
        else {
            List<Integer> list = graph.get(src);
            list.add(dst);
            graph.put(src,list);
        }
    }

    private static boolean detectCycle(int src){


        return true;
    }

    public static void main(String[] args) {
       addEdge(1,0);
       addEdge(0,2);
       addEdge(2,1);
       addEdge(0,3);
       addEdge(3,4);
       System.out.println(graph);
    }

}
