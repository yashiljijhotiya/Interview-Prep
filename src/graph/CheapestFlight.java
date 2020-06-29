package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/*Leetcode : 787
*
* */
public class CheapestFlight {

    private static int findCheapestFlight(int [][] flights, int src, int dst, int stops){
        int n = flights.length;
        int adjMat[][] = new int[n][n];
        for(int [] flight : flights){
            adjMat[flight[0]][flight[1]] = flight[2];
        }
        int currStops[] = new int[n];
        int distance[] = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(currStops, Integer.MAX_VALUE);
        distance[src] = 0;
        currStops[src] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.offer(new int[]{src,0,0});

        while (!queue.isEmpty()){

        }


        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public static void main(String[] args) {
        int [][] flights = {{0,1,100},{1,2,100},{0,2,500}};
    }
}
