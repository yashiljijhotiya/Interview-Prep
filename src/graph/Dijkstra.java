package graph;

import java.util.Arrays;

public class Dijkstra {

    private static void findShortestPath(int [][]adjMat, int src, int dst){
        int size = adjMat.length;
        boolean [] visited = new boolean[size];
        int [] dist = new int[size];
        Arrays.fill(visited, false);
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i < size-1; i++){
            int index = minDistance(dist,visited);
            visited[index] = true;

            for(int j = 0; j < size; j++){
                if(visited[j] && adjMat[i][j] != 0 && dist[i] != Integer.MAX_VALUE
                && dist[index] + adjMat[i][j] < dist[j]){
                    dist[j] = dist[index] + adjMat[i][j];
                }
            }
        }
    }

    private static int minDistance(int dist[], boolean [] visited){
        int min = Integer.MAX_VALUE, index = -1;
        for(int i = 0; i < dist.length; i++){
            if(visited[i] && dist[i] <= min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }

    private static void printDist(int dist){

    }

    public static void main(String[] args) {
        int adjMat [][] = {{0,1,100},{1,2,100},{0,2,400}};

    }
}
