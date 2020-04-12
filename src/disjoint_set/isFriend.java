package disjoint_set;
import java.util.HashMap;
import java.util.Map;

public class isFriend {

    private static Map<Integer,Integer> parent = new HashMap<>();
    private static Map<Integer,Integer>rank = new HashMap<>();

    private static void makeSet(int peoples[]){
        for(int i : peoples){
            parent.put(i,i);
            rank.put(i,0);
        }
    }

    private static int find(int s){
        if(parent.get(s) != s){
            parent.put(s, find(parent.get(s)));
        }
        return parent.get(s);
    }

    private static void union(int a, int b){
        int x = find(a);
        int y = find(b);
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


    private static void isFriends(int peoples [], int from[], int to[], int a, int b){
       makeSet(peoples);
       for(int i = 0; i < from.length; i++){
           union(from[i], to[i]);
       }
       if(find(a) == find(b)){
           System.out.println(a+" is friend of " +b);
       }
       else {
           System.out.println(a+" is not friend of " +b);
       }

    }

    public static void main(String[] args) {
        int peoples [] = {0,1,2,3,4};
        int from[] = {0,2};
        int to[] =   {1,3};
        isFriends(peoples,from,to, 0, 2);

    }
}
