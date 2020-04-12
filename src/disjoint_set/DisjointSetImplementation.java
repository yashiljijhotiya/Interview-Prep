package disjoint_set;

import java.util.HashMap;
import java.util.Map;

public class DisjointSetImplementation {

    private  static Map<Integer,Integer> parent = new HashMap<>();
    private  static Map<Integer,Integer> rank = new HashMap<>();

    private static void makeSet(int disjoint[]){
      for(int i : disjoint){
          parent.put(i,i);
          rank.put(i,0);
      }
    }

    //Time complexity is equal to max depth O(d);
    private static int find(int s){
        if(parent.get(s) != s){
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

    private static void union(int s1, int s2){
        int x = find(s1);
        int y = find(s2);

        if(x == y){
            return;
        }

        if(rank.get(x) > rank.get(y)){
            parent.put(y,x);
        }
        else if(rank.get(x) < rank.get(y)){
            parent.put(x,y);
        }
        else{
            parent.put(x,y);
            rank.put(y, rank.get(y) +1);
        }
    }

    public static void main(String[] args) {
        int disjoint[] = {0,1,2,3,4};
        makeSet(disjoint);
        //System.out.println(find(2));
        union(0,1);
        union(0,4);
        union(1,4);
        union(0,3);
        System.out.println(find(3));

    }
}
