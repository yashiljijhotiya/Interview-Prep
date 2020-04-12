package interview_question;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSetAcko {

    private static void getTotalDisjoint(int from[], int to[], int capacity[], int threshold, int nodes, int connectedEdges){
        int result[] = new int[connectedEdges];
        Map<Integer,Integer> parentLookup = new HashMap<>();
        Map<Integer,Set<Integer>> disjointSet = new HashMap<>();
        Map<Integer, Integer> mergeCapacity = new HashMap<>();
/*{0,1,0}
{1,4,4}
0 -> 0
1 -> 0
2 -> 2
3 -> 3
4 -> 1
* */
        for(int i = 0; i < nodes; i++){
            mergeCapacity.put(i,capacity[i]);
            Set<Integer> set = new HashSet<>();
            set.add(i);
            disjointSet.put(i, set);
            parentLookup.put(i,i);
        }

        for(int i = 0; i < connectedEdges; i++){
             if(parentLookup.get(to[i]) == to[i] && parentLookup.get(from[i]) == from[i]){
                 //updating parent lookup
                 parentLookup.put(to[i], from[i]);
                 //updating disjoint
                 Set<Integer> toSet = disjointSet.get(to[i]);
                 Set<Integer> fromSet = disjointSet.get(from[i]);
                 Set<Integer> merge = new HashSet<>();
                 merge.addAll(toSet);
                 merge.addAll(fromSet);
                 disjointSet.put(from[i], merge);
                 disjointSet.remove(to[i]);

                 //updating capacity
                mergeCapacity.put(from[i], mergeCapacity.get(from[i]) + mergeCapacity.get(to[i]));
                mergeCapacity.remove(to[i]);

             }
             else {
                 int toParent = parentLookup.get(to[i]);
                 int fromParent = parentLookup.get(from[i]);
                 if(fromParent != from[i] && toParent == to[i]){
                     //updating parent
                     parentLookup.put(toParent,fromParent);
                     //updating disjoint
                     Set<Integer> toSet = disjointSet.get(toParent);
                     Set<Integer> fromSet = disjointSet.get(fromParent);
                     Set<Integer> merge = new HashSet<>();
                     merge.addAll(toSet);
                     merge.addAll(fromSet);
                     disjointSet.put(fromParent, merge);
                     disjointSet.remove(toParent);

                     //updating capacity
                     mergeCapacity.put(fromParent, mergeCapacity.get(fromParent) + mergeCapacity.get(toParent));
                     mergeCapacity.remove(toParent);

                 }
//                 else{
//                     parentLookup.put(toParent,fromParent);
//                     //updating disjoint
//                     Set<Integer> toSet = disjointSet.get(toParent);
//                     Set<Integer> fromSet = disjointSet.get(fromParent);
//                     Set<Integer> merge = new HashSet<>();
//                     merge.addAll(toSet);
//                     merge.addAll(fromSet);
//                     disjointSet.put(fromParent, merge);
//                     disjointSet.remove(toParent);
//
//                     //updating capacity
//                     mergeCapacity.put(fromParent, mergeCapacity.get(fromParent) + mergeCapacity.get(toParent));
//                     mergeCapacity.remove(toParent);
//
//                 }
             }
             int c = 0;
             for(Integer val : mergeCapacity.values()){
                 if(val <= threshold){
                     c++;
                 }
             }
             result[i] = c;

        }

        System.out.println("Parent Lookup" + parentLookup);
        System.out.println("disjointSet" +disjointSet);
        System.out.println("mergeCapacity" +mergeCapacity);

        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

    }


    public static void main(String[] args) {
        int from[] = {0,1,0};
        int to[] = {1,4,4};
        int capacity[] = {1,2,3,4,5};
        int threshold = 4;
        int nodes = 5;
        int connectedEdges = 3;
        getTotalDisjoint(from,to,capacity,threshold,nodes,connectedEdges);
    }
}
