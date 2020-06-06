package disjoint_set;
import java.util.Arrays;
import java.util.HashMap;

public class Kruskal {

    private static HashMap<Integer, Integer> parent = new HashMap<>();

    private static void makeSet(int nodes){
        for(int i = 0; i <= nodes; i++){
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

    private static void findMST(int connections[][], int nodes) {
        if (nodes == 0) {
            return;
        }
        int cost = 0;
        makeSet(nodes);

        // sort by weight
        Arrays.sort(connections, (a, b) -> {
            return a[2] - b[2];
        });

        for (int[] connection : connections) {
            if (find(connection[0]) != find(connection[1])) {
                System.out.println(connection[0] + "  --  " + connection[1] + " --> " +connection[2]);
                union(connection[0], connection[1]);
            }
        }

    }

    public static void main(String[] args) {
        int mat[][] = { {0,1,7},
                        {0,3,5},
                        {1,2,8},
                        {2,4,5},
                        {1,4,7},
                        {3,4,15},
                        {3,5,6},
                        {5,6,11},
                        {4,6,9},
                        {4,5,8}};
        findMST(mat, 6);
    }
}
