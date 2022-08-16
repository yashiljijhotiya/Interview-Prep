package graph.mst;

import java.util.PriorityQueue;

public class PrimsAlgo {
    private static class Pair{
        int src;
        int nbr;
        int wt;
        Pair(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private static void findMST(int [][] connections, int n){
        if(connections == null || connections.length == 0){
            return;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Pair(0,1,-1 ));
        boolean [] visited = new boolean[n];
        while (pq.size() > 0){
            Pair p = pq.poll();
            if(!visited[p.nbr]){

            }
        }


    }


}
