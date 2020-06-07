package disjoint_set;
import java.util.Arrays;
import java.util.HashMap;

public class RepairRoad {

    private static HashMap<Integer, Integer> parent = new HashMap<>();

    private static void makeSet(int nodes){
        for(int i = 1;  i <= nodes; i++){
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

    private static int minCostToRepair(int [][] edges, int [][] newEdges, int vertices){
        int cost = 0, num = vertices;
        makeSet(vertices);

        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(find(x) != find(y)){
                union(x,y);
                num--;
            }
        }

        if(num == 0){
            return 0;
        }

        Arrays.sort(newEdges, (a,b) -> a[2] - b[2]);

        for(int i = 0; i < newEdges.length; i++){
            int x = newEdges[i][0];
            int y = newEdges[i][1];
            if(find(x) != find(y)){
                union(x,y);
                cost +=  newEdges[i][2];
                num--;
            }
        }

        return num == 1 ? cost : -1;
    }

    public static void main(String[] args) {

        int [][] edges = {{1, 4}, {4, 5}, {2, 3}};
        int [][] newEdges = {{1, 2, 5}, {1, 3, 10}, {1, 6, 2}, {5, 6, 5}};
        int vertices = 6;
        System.out.println(minCostToRepair(edges,newEdges,vertices));


    }
}
