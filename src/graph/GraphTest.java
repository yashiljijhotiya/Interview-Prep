package graph;

import java.util.*;

public class GraphTest {
    HashMap<Integer, LinkedList<Integer>> h = new HashMap<>();

    private  void addEdge(int src, int dst){
        if(h.containsKey(src)){
            var temp = h.get(src);
            temp.add(dst);
            h.put(src,temp);
        }
        else{
            var list = new LinkedList<Integer>();
            list.add(dst);
            h.put(src,list);
        }
    }

    private void print(){
       for(Map.Entry m : h.entrySet()){
           System.out.println(m.getKey() +" --> " + m.getValue());
       }
    }

    private void bfs(int src){
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(src);
        q.add(src);
        while(!q.isEmpty()){
            var temp = q.poll();
            System.out.println(temp);
            var l = h.get(temp);

            for(var i : l){
                if(!hs.contains(i)){
                    q.add(i);
                    hs.add(i);
                }
            }

        }

    }

    private void dfs(int v, int src){
     HashSet<Integer> hs = new HashSet<>();
     for(int i =0; i < v; i++){
       if(!hs.contains(src)){
           dfsUtil(src,hs);
       }
     }

    }

    private void dfsUtil(int src, HashSet<Integer> visited){
      Stack<Integer> s = new Stack<>();
      s.push(src);
      visited.add(src);
      while(!s.empty()){
          var temp = s.pop();
          System.out.println(temp);
          var list =  h.get(temp);
          for(var i : list ){
              if(!visited.contains(i)){
                  s.push(i);
                  visited.add(i);
              }
          }
      }

    }

    private boolean detectCycle(int v, int src){
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> recStack = new HashSet<>();
        for(int i =0; i < v; i++){
            if(detectCycleUtil(hs,recStack,src))
            {
                return true;
            }
        }
        return false;
    }

    private boolean detectCycleUtil(HashSet<Integer> visited, HashSet<Integer> recStack, int src ){
        if(recStack.contains(src)){
            return true;
        }
        if(visited.contains(src)){
            return false;
        }
        visited.add(src);
        recStack.add(src);
        var list = h.get(src);
        for(var i : list){
            if(detectCycleUtil(visited,recStack,i)){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        GraphTest g = new GraphTest();

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("graph rep:");
        g.print();
        System.out.println("bfs of graph is: ");
        g.bfs(2);
        System.out.println("dfs of graph is: ");
        g.dfs(4,2);
    }
}
