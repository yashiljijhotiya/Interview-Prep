package disjoint_set;
import java.util.Arrays;
import java.util.HashMap;

public class ConnectingCityMinCost {

    private static HashMap<Integer, Integer> parent = new HashMap<>();

    private static void makeSet(int nodes){
        for(int i = 0;  i < nodes; i++){
            parent.put(i,i);
        }
    }

    private static int find(int node){
        if(parent.get(node) == node){
            return node;
        }

        return find(parent.get(node));
    }

    private static void union(int node1, int node2){
        int root1 = find(node1);
        int root2 = find(node2);
        parent.put(root1, root2);
    }


    private static int findMinCostToConnect(int connections[][], int nodes){
        int cost = 0;

        if(nodes == 0 || connections == null || connections.length == 0){
            return cost;
        }

        Arrays.sort(connections, (a,b) -> {
            return a[2] - b[2];
        });
        makeSet(nodes);
        for (int [] connection : connections){
            if(find(connection[0]) != find(connection[1])){
                cost += connection[2];
                union(connection[0], connection[1]);
            }
        }
        int group = find(0);
        for(int i = 0; i < nodes; i++){
             if(find(i) != group){
                 return -1;
             }
        }

        return cost;
    }

    public static void main(String[] args) {

        int [][] connections = {{0,1,5}, {0,2,6}, {1,2,1}};
        System.out.println(findMinCostToConnect(connections,3));

    }
}
